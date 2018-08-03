package exercises;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddjustPersonalTest {
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
        //driver.quit();System.out.println("-Browser closing succeed");
    }
    @Test
    public void adjustPersonal(){
        driver.manage().window().maximize();
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("andy.leenders@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys("azerty789+");
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.className("icon-user")).click();
        WebElement firstName = driver.findElement(By.id("firstname"));
        if (firstName.getText().contains("Andy")){
            firstName.clear();
            firstName.sendKeys(("Wendy"));
        }else if(firstName.getText().contains("Wendy")){
            firstName.clear();
            firstName.sendKeys("Andy");
        }else{
            firstName.clear();
            firstName.sendKeys(("Andy"));
        }
        driver.findElement(By.id("old_passwd")).sendKeys(("azerty789+"));
        driver.findElement(By.name("submitIdentity")).click();
        boolean succesful = driver.findElement(By.className("alert-success")).isDisplayed();
        Assertions.assertThat(succesful).isTrue();

    }
}
