import Init.Init;
import PageObjects.HotelBookingForm;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CreateBookingTest {
    final String url ="http://hotel-test.equalexperts.io/";
    WebDriver driver;
    Init initobj;
    HotelBookingForm hotelBookingForm;
    Random ran;
    Map InputList;
    String browser="chrome";
    String platform="mac";

    @Test
    public void AddBooking(){



        initobj=new Init();

        driver=initobj.getBrowserDriver(browser,platform);

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Map<String,String> InputList= new Map<String,String>;
        ran = new Random();
        InputList=new HashMap();

        InputList.put("firstname","testfname"+ran.nextInt(10));
        InputList.put("surname","testlname"+ran.nextInt(10));
        InputList.put("price","100");
        InputList.put("deposit","true");
        InputList.put("checkin","2017-10-15");
        InputList.put("checkout","2017-10-19");

        hotelBookingForm=new HotelBookingForm(driver);

        hotelBookingForm.CreateANewBooking(InputList);

       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @After
    public void cleanup(){
        initobj= new Init();
        initobj.KillBrowser(driver);

    }

}
