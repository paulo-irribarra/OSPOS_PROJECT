package stepdefinition;

import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

import java.sql.Driver;

public class LoginDefinition {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;


    @Given("Entro al portal {string}")
    public void entroAlPortal(String url) {
        driver = BasePage.getDriver();
        driver.get(url);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @When("ingresa usuario {string} y contraseña {string}")
    public void ingresaUsuarioYContraseña(String user, String pass) {
        Assert.assertTrue("No se visualiza la imagen principal del login" , loginPage.isVisibleImgLogin());
        loginPage.sendKeysInputUser(user);
        loginPage.sendKeysInputPass(pass);
    }

    @And("presiona el botón de login")
    public void presionaElBotónDeLogin() {
        loginPage.clickBtnIngresar();
    }

    @Then("debería ver la página de inicio")
    public void deberíaVerLaPáginaDeInicio() {
        Assert.assertTrue("La Imagen del Home no se esta mostrando :(", homePage.isVisibleImgHome() );
    }
}
