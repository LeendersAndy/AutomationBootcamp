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
    public void emptyCard() {

}}

