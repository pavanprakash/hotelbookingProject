package PageObjects;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class HotelBookingForm {
    WebDriver driver;

    //constructor to initialise page factory
    public HotelBookingForm(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "firstname")
    private WebElement firstname;

    @FindBy(how = How.ID, using = "lastname")
    private WebElement surname;

    @FindBy(how = How.ID, using = "totalprice")
    private WebElement price;

    @FindBy(how = How.ID, using = "depositpaid")
    private WebElement deposit;

    @FindBy(how = How.ID, using = "checkin")
    private WebElement checkindate;

    @FindBy(how = How.ID, using = "checkout")
    private WebElement checkoutdate;

    @FindBy(how = How.XPATH, using = "//input[@id='checkout']/../following-sibling::div/input")
    private WebElement savebtn;


  public void CreateANewBooking(Map<String,String> InputMap ){

      if(InputMap.get("firstname")!=null){
          firstname.sendKeys(InputMap.get("firstname"));
      }

      if(InputMap.get("surname")!=null){
          surname.sendKeys(InputMap.get("surname"));
      }

      if(InputMap.get("price")!=null){
          price.sendKeys(InputMap.get("price"));
      }

      if(InputMap.get("deposit")!=null){
          List<WebElement> elementList= deposit.findElements(By.xpath("option"));
          for(WebElement element : elementList) {
              if (element.getText() == InputMap.get("deposit")) {
                  element.click();
              }
          }
      }

      if(InputMap.get("checkin")!=null){
          checkindate.sendKeys(InputMap.get("checkin"));
      }

      if(InputMap.get("checkout")!=null){
          checkoutdate.sendKeys(InputMap.get("checkout"));
     }

      savebtn.click();

  }

    public void VerifyIfBookingIsAdded(String name){


        boolean b=driver.findElement(By.xpath("//p[text()='"+name+"']")).isDisplayed();
        Asserts.check(b,"Verified hotel booking with name : "+name+" is added successfully");
    }
}
