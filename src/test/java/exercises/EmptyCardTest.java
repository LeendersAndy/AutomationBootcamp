package exercises;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmptyCardTest {
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
        driver.quit();System.out.println("-Browser closing succeed");
    }
    @Test
    public void emptyCard() {
        boolean isPresent;
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a")).click();
        //controleer of iPod shuffle of iPod Nano selecteerbaar is
        if (isPresent = driver.findElements(By.xpath("//*[@id='product_list']/li[2]/div/div[2]/h5/a[contains(text(),'iPod Shuffle')]")).size() > 0){
            driver.findElement(By.xpath("//*[@id='product_list']/li[2]/div/div[2]/h5/a[contains(text(),'iPod shuffle')]")).click();
            naarCard();
        }else if(isPresent = driver.findElements(By.xpath("//*[@id='product_list']/li[1]/div/div[2]/h5/a[contains(text(),'iPod Nano')]")).size() > 0){
            driver.findElement(By.xpath("//*[@id='product_list']/li[1]/div/div[2]/h5/a[contains(text(),'iPod Nano')]")).click();
            naarCard();
        }else{
            System.out.println("Geen gekend product beschikbaar voor aan te duiden, test wordt afgebroken.");
        }



    }
    public void naarCard(){
        //product naar cart
        driver.findElement(By.name("Submit")).click();
        //continue shopping
        driver.findElement(By.xpath("//*[@id='product']")).click();
        //ga naar cart
        driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/div[3]/div/a")).click();
        driver.navigate().refresh();
        //verwijder het product
        driver.findElement(By.className("cart_quantity_delete")).click();
        driver.navigate().refresh();
        //controleer als cart leeg is
        Assertions.assertThat(driver.findElement(By.className("alert-warning")).isDisplayed()).isTrue();
    }

}
