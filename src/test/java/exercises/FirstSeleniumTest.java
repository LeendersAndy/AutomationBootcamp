package exercises;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;

import java.util.concurrent.TimeUnit;

public class FirstSeleniumTest extends TestShopScenario {
    int ascii = 0x2713;
    String check = Character.toString((char)ascii);
    protected WebDriver driver;
    @Test
    public void logInSuccesful() throws InterruptedException{
        //ChromeDriverManager.getInstance().setup();
        //WebDriver driver = new ChromeDriver();
        driver.get("https://techblog.polteq.com/testshop/index.php");
        driver.manage().window().maximize();System.out.println("-Page loaded correctly" + check);
        driver.findElement(By.className("login")).click();System.out.println("-Redirect to loginpage succeeded"+ check);
        driver.findElement(By.id("email")).sendKeys("andy.leenders@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys("azerty789+");
        driver.findElement(By.id("SubmitLogin")).click();System.out.println("-Login submitted"+ check);

        //Assert testen
        Boolean assertBoolean = driver.findElement(By.className("addresses-lists")).isDisplayed();
        Assertions.assertThat(assertBoolean).as("Adressenlijst is weergegeven").isTrue();System.out.println("-Adressenlijst weergegeven"+ check);

        String assertText = driver.findElement(By.className("logout")).getText();
        Assertions.assertThat(assertText).as("Tekst bevat geen Sign Out").contains("Sign out"); System.out.println("-Sign Out button aanwezig \n-Succesfully logged in because presence 'Sign Out' "+ check);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.quit();

    }
}
