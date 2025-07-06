package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }

    @FindBy(className = "logo")
    private WebElement imgLogin;

    @FindBy(id = "input-username")
    private WebElement inputUser;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement inputPass;

    @FindBy(xpath = "//button[@name='login-button']")
    private WebElement btnIngresar;

    @FindBy(xpath = "//div[@class='error']")
    private WebElement mensajeCredencialesInvalidas;

    public boolean isVisibleMensajeError(){
        waitForVisibility(mensajeCredencialesInvalidas);
        return mensajeCredencialesInvalidas.isEnabled();
    }

    public boolean isVisibleImgLogin(){
        waitForVisibility(imgLogin);
        return imgLogin.isDisplayed();
    }

    public void sendKeysInputUser(String user){
        waitForVisibility(inputUser);
        inputUser.sendKeys(user);
    }

    public void sendKeysInputPass(String pass){
        waitForVisibility(inputPass);
        inputPass.click();
        inputPass.sendKeys(pass);
    }

    public void clickBtnIngresar(){
        waitForVisibility(btnIngresar);
        btnIngresar.click();
    }

}
