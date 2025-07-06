package stepdefinition;

import base.BasePage;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class HomeDefinition {

    WebDriver driver;
    LoginPage loginPage;
    private final HomePage homePage = new HomePage(BasePage.getDriver());

    @And("hacer click en la opcion {string} en la barra horizontal")
    public void hacerClickEnLaOpcionEnLaBarraHorizontal(String opcion) {
        homePage.clickOpcionMenu(opcion);
    }

}
