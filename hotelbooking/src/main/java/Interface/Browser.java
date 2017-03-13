package Interface;
import org.openqa.selenium.WebDriver;
/**
 * Created by sapna on 09/02/2017.
 */
public interface Browser {

     WebDriver getBrowserDriver(String browserName,String platform);
}
