package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='navbar-brand hidden-sm']")
    private WebElement imgHome;

    public boolean isVisibleImgHome(){
        waitForVisibility(imgHome);
        return imgHome.isEnabled();
    }

    public void clickOpcionMenu(String opcion){
        String xpath = "//a[@title='"+opcion+"']";
        waitForVisibility(By.xpath(xpath));
        WebElement btnNavBar = driver.findElement(By.xpath(xpath));
        btnNavBar.click();
    }



}
