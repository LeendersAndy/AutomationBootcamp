package exercises;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidateSupplierProductTest {
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
        driver.quit();
    }
    @Test
    public void validateSupplierProduct(){
        Select dropdown = new Select(driver.findElement(By.name("supplier_list")));
        dropdown.selectByVisibleText("AppleStore");
        List<WebElement> products = driver.findElements(By.cssSelector("[id='center_column'] [class=product-name]"));
        List<String> currentOptions = new ArrayList<String>();
        boolean macbookAirPresent = false;

        for(WebElement product : products){
            currentOptions.add(product.getText());
        }
        for(String options : currentOptions){
            if(options.contains("MacBook Air")) {
            macbookAirPresent = true;
            }
        }
        Assertions.assertThat(macbookAirPresent).as("Er is geen MacBook Air gevonden").isTrue();
    }
}
