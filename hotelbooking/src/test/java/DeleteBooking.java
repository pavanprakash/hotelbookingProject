import org.junit.Test;
import org.openqa.selenium.By;

public class DeleteBooking extends CreateBookingTest {

    CreateBookingTest createBookingTest =new CreateBookingTest();

    @Test
    public void DeletABooking(){

    createBookingTest.CreateABooking();
    Deletebookingmade();

    }

    public void Deletebookingmade(){
        String name=InputList.get("firstname").toString();
        if(driver.findElement(By.cssSelector("p:contains('"+name+"')")).isDisplayed()){
            driver.findElement(By.xpath("//input[text()='"+name+"']/../following-sibling::div/input")).click();
        }
    }


}
