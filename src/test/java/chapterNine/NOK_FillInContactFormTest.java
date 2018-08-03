package chapterNine;

import exercises.TestShopScenario;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class NOK_FillInContactFormTest extends TestShopScenario {
    @Test
    public void NOK_FillInContactFormTest(){
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        homePage.clickContactUS();
        contactUsPage.fillInContactForm("","nope","4321234","Help!");
        contactUsPage.validationMessage();
    }
}
