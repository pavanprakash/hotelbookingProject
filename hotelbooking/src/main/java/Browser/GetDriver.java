package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by sapna on 09/02/2017.
 */
public class GetDriver {

    public static WebDriver CreateChromeDriver(String platform){
        String chromedriverexec=null;

        if(platform.equals("windows"))
        {
            chromedriverexec=   "chromedriver.exe";
        }
        else if(platform.equals("mac")){
            chromedriverexec=   "chromedriver";
        }
        else{
            chromedriverexec=   "chromedriver.exe";
        }

        System.setProperty("webdriver.chrome.driver", "src//main//resources//drivers//"+chromedriverexec);
        WebDriver driver = new ChromeDriver();

        return driver;
    }
    public void KillBrowser(WebDriver driver){
        driver.quit();
    }
}
