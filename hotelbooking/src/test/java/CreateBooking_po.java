import Init.Init;
import PageObjects.HotelBookingForm;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CreateBooking_po {
    final String url ="http://hotel-test.equalexperts.io/";
    WebDriver driver;

    @Test
    public void OpenUrl(){



        Init initobj=new Init();
        driver=initobj.getBrowserDriver("chrome");

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   // }

    //@Test
    //public void AddBooking(){

        //Map<String,String> InputList= new Map<String,String>;
        Map InputList=new HashMap();
        InputList.put("firstname","pavan");
        InputList.put("surname","prakash");
        InputList.put("price","100");
        InputList.put("deposit","true");
        InputList.put("checkin","2017-02-15");
        InputList.put("checkout","2017-02-19");

        HotelBookingForm hotelBookingForm=new HotelBookingForm(driver);
        hotelBookingForm.CreateANewBooking(InputList);
    }
    @After
    public void CleanUp(){
        driver.quit();
    }
}
