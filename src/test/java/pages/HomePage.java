package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='navbar-brand hidden-sm']")
    private WebElement imgHome;

    public boolean isVisibleImgHome(){
        waitForVisibility(imgHome);
        return imgHome.isEnabled();
    }

    //a[@class='navbar-brand hidden-sm']


}
