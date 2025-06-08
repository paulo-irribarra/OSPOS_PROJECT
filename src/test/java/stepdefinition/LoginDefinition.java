package stepdefinition;

import base.BasePage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.sql.Driver;

public class LoginDefinition {

    WebDriver driver;
    LoginPage loginPage;


    @Given("Entro al portal {string}")
    public void entroAlPortal(String url) {
        driver = BasePage.getDriver();
        driver.get(url);
        loginPage = new LoginPage(driver);

    }

}
