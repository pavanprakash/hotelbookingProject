import Init.Init;
import PageObjects.HotelBookingForm;
import junit.framework.TestCase;
import org.apache.http.util.Asserts;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CreateBookingTest {
    final String url ="http://hotel-test.equalexperts.io/";

    WebDriver driver;
    Map InputList=new HashMap();
    public CreateBookingTest(){

        Init initobj = new Init();
        String browser= System.getProperty("Browser");
        driver = initobj.getBrowserDriver(browser);

        InputList.put("firstname","pavan");
        InputList.put("lastname","prakash");
        InputList.put("price","100");
        InputList.put("deposit","true");
        InputList.put("checkin","2017-02-15");
        InputList.put("checkout","2017-02-19");
    }


    @Test
    public void CreateABooking(){
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("firstname")).sendKeys(InputList.get("firstname").toString());
        driver.findElement(By.id("lastname")).sendKeys(InputList.get("lastname").toString());
        driver.findElement(By.id("totalprice")).sendKeys(InputList.get("price").toString());
        driver.findElement(By.xpath("//select")).click();
        driver.findElement(By.xpath("//select/option[text()='true']")).click();
        driver.findElement(By.id("checkin")).sendKeys(InputList.get("checkin").toString());
        driver.findElement(By.id("checkout")).sendKeys(InputList.get("checkout").toString());

        //click on save button
        driver.findElement(By.xpath("//input[@id='checkout']/../following-sibling::div/input")).click();

        VerifyIfBookingAdded();


    }


    public void VerifyIfBookingAdded(){
        String name=InputList.get("firstname").toString();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Asserts.check(driver.findElement(By.xpath("p[contains(text(),'"+name+"')]")).isDisplayed(),"Verified hotel booking with nam  e : "+name+" is added successfully");

    }

    public void DelteABooking(){
        String name=InputList.get("firstname").toString();
        if(driver.findElement(By.cssSelector("p:contains('"+name+"')")).isDisplayed()){
            driver.findElement(By.cssSelector("p:contains('"+name+"')")).click();
        }
    }

    @After
    public void CleanUp(){
        driver.quit();
    }

}
