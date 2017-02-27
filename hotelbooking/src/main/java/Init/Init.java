package Init;

import Browser.GetDriver;
import org.openqa.selenium.WebDriver;


public class Init extends GetDriver implements Interface.Browser{


    public WebDriver getBrowserDriver(String browserName){
        WebDriver driver=null;

        GetDriver getDriver=new GetDriver();

        if (browserName.equals("chrome")) {
            driver = getDriver.CreateChromeDriver();

        }
        else if (browserName.equals("firefox")){

            driver=getDriver.CreateFirefoxDriver();
        }

        return driver;
    }
}
