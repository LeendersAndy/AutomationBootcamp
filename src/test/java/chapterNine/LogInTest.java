package chapterNine;

import Browser.BrowserFactoryAdvanced;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class LogInTest {
    protected WebDriver driver;

    @Test
    public void LogInTest() {
        SetUpPage("https://techblog.polteq.com/testshop/index.php");
        LogIn("bootcamper@feelthepain.com", "1qazxsw2");
    }


    public void SetUpPage(String url) {
        driver = BrowserFactoryAdvanced.getDriver(BrowserFactoryAdvanced.Browser.CHROME);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void CheckUserSignedIn() {

    }

    public void LogIn(String username, String passwd) {
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(passwd);
        driver.findElement(By.id("SubmitLogin")).click();
    }

    public void tearDown() {
        driver.quit();
    }
}
