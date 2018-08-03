package Browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactoryMedior {
    public static WebDriver getDriver (String browser) {
        WebDriver driver;

        switch(browser.toLowerCase()){
            case "firefox":
                return createFireFoxBrowser();
            case "chrome":
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
