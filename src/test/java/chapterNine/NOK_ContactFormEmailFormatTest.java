package chapterNine;

import exercises.TestShopScenario;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class NOK_ContactFormEmailFormatTest extends TestShopScenario {
    @Test
    public void NOK_ContactFormEmailFormatTest(){
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        homePage.clickContactUS();
        contactUsPage.fillInContactForm("","nope","4321234","Help!");
        System.out.println(contactUsPage.getInvalidEmailMessage());
    }
}
