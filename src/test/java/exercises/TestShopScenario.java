package exercises;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestShopScenario {
    int ascii = 0x2713;
    String check = Character.toString((char)ascii);
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        System.out.println("Tested steps:");
        driver.get("https://techblog.polteq.com/testshop/index.php");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();System.out.println("-Browser closing succeed, test passed"+ check);
    }
    @Test
    public void logInSuccesful() throws InterruptedException{
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        System.out.println("Tested steps:");
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
        Assertions.assertThat(assertText).as("Tekst bevat geen Sign Out").contains("Sign out"); System.out.println("-Sign Out button aanwezig /n -Succesfully logged in because presence 'Sign Out' "+ check);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }
}
