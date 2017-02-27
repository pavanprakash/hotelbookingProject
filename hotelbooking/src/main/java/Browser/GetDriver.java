package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by sapna on 09/02/2017.
 */
public class GetDriver {

public  WebDriver CreateChromeDriver(){

    System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
    WebDriver driver = new ChromeDriver();

    return driver;
}

public WebDriver CreateFirefoxDriver(){
    WebDriver driver = new FirefoxDriver();

    return driver;
    }
}
