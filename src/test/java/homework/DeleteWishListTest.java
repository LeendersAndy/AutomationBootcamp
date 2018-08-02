package homework;

import Browser.BrowserFactoryAdvanced;
import Browser.BrowserFactoryBasic;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;


public class DeleteWishListTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver  = BrowserFactoryAdvanced.getDriver(BrowserFactoryAdvanced.Browser.CHROME);
        driver.get("https://techblog.polteq.com/testshop/index.php");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
       driver.quit();
    }

    @Test
    public void deleteWishListItem() {
        logInToWishlist();
        //toekennen waarden
        String sColValue = "Delete";
        String sRowValue = "Feel the pain";

        // controleren aantal kolommen en rijen in de tabel
        List<WebElement> headerCollection = driver.findElements(By.xpath("//*[@class='table table-bordered']/thead/tr/th"));
        List<WebElement> rowCollection = driver.findElements(By.xpath(".//*/table/tbody/tr"));

        for (int i = 1; i <= headerCollection.size(); i++) {
            String sValue = null;
            sValue = driver.findElement(By.xpath("//*[@id='block-history']/table/thead/tr[1]/th[" + i + "]")).getText();
            if (sValue.equalsIgnoreCase(sColValue)) {
                for (int j = 1; j <= rowCollection.size(); j++) {
                    String srValue = driver.findElement(By.xpath(".//*/table/tbody/tr[" + j + "]")).getText();
                    if (srValue.contains(sRowValue)) {
                        driver.findElement(By.xpath("//*/table/tbody/tr["+ j + "]/td[7]/a/i[@class='icon-remove']")).click();
                        Alert alert = driver.switchTo().alert();
                        ((Alert) alert).accept();
                        break;
                    }
                }

            }
        }
    }
    public void logInToWishlist(){
        driver.manage().window().maximize();
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("andy@leenders.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.className("lnk_wishlist")).click();
    }
}
