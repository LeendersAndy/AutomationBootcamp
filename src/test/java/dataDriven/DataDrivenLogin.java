package dataDriven;

import com.opencsv.CSVReader;
import exercises.TestShopScenario;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.HomePage;

import java.io.FileReader;
import java.io.IOException;

public class DataDrivenLogin extends TestShopScenario {
    //@Parameters({"email", "password"})
    @Test
    public void login() throws IOException {
        readCSV();
    }
    public void readCSV() throws IOException {
        String CSV_PATH="C:\\Users\\Gebruiker\\Documents\\DDT.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
        String [] csvCell;

        while ((csvCell = reader.readNext()) != null) {
            String email = csvCell[0];
            String password = csvCell[1];
            HomePage myHomePage = new HomePage(driver);
            myHomePage.clickLogIn();
            AuthenticationPage myAuthenticationPage = new AuthenticationPage(driver);
            myAuthenticationPage.login(email, password);
        }
    }

}