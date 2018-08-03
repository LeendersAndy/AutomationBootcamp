package Browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactoryAdvanced {
    public enum Browser{
        CHROME,
        FIREFOX,
        IE;
    }
    public static WebDriver getDriver (Browser browser) {
        switch(browser){
            case FIREFOX:
                return createFireFoxBrowser();
            case CHROME:
                return createChromeBrowser();
            default:
                return createChromeBrowser();
        }
    }
    private static WebDriver createChromeBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("ignore-certificate-erroors");
        options.addArguments("disable-infobars");
        options.setCapability("chrome.switches", "--verbose");
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver(options);
    }
    private static WebDriver createFireFoxBrowser(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        options.addArguments("ignore-certificate-erroors");
        options.addArguments("disable-infobars");
        options.setCapability("firefox.switches", "--verbose");
        ChromeDriverManager.getInstance().setup();
        return new FirefoxDriver(options);
    }
}
