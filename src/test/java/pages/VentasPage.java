package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class VentasPage extends BasePage {

    private final WebDriver driver;

    public VentasPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='item']")
    private WebElement inputBuscarArticulo;

    @FindBy(xpath = "//div[@id='add_payment_button']")
    private WebElement btnAgregarPago;

    @FindBy(xpath = "//*[@id=\"finish_sale_button\"]")
    private WebElement btnCompletarVenta;

    @FindBy(xpath = "//div[@id='sale_id']")
    private WebElement boleta;

    @FindBy(xpath = "(//input[@name='submit'])[1]")
    private WebElement btnRetomar;

    @FindBy(xpath = "//div[@class='bootstrap-dialog-header']")
    private WebElement modalVenatsSuspendidas;

    @FindBy(xpath = "//button[@id='show_suspended_sales_button']")
    private WebElement btnSuspendidas;


    public void realizarVenta(Map<String, String> dataTable){
        Actions actions = new Actions(driver);
        esperarElementoListo(inputBuscarArticulo,20);
        actions.moveToElement(inputBuscarArticulo).click().sendKeys(dataTable.get("1 Artículo")).sendKeys(Keys.ENTER).build().perform();

        By xpath = By.xpath("//td[normalize-space()='" + dataTable.get("1 Artículo") + "']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement celda = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        Assert.assertEquals("El texto encontrado no coincide", dataTable.get("1 Artículo"), celda.getText().trim());
        System.out.println(dataTable.get("1 Artículo"));

        waitForVisibility(btnAgregarPago);
        btnAgregarPago.click();

        waitForVisibility(btnCompletarVenta);
        btnCompletarVenta.click();
    }

    public boolean isVisibleidBoleta(){
        esperarElementoListo(boleta,10);
        String idBoleta = boleta.getText();
        System.out.println("Id de la boleta" + idBoleta);
        return boleta.isEnabled();
    }

    public void agregarArticuloAlCarro(Map<String, String> dataTable){
        Actions actions = new Actions(driver);
        esperarElementoListo(inputBuscarArticulo,20);
        actions.moveToElement(inputBuscarArticulo).click().sendKeys(dataTable.get("1 Artículo")).sendKeys(Keys.ENTER).build().perform();

        By xpath = By.xpath("//td[normalize-space()='" + dataTable.get("1 Artículo") + "']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement celda = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        Assert.assertEquals("El texto encontrado no coincide", dataTable.get("1 Artículo"), celda.getText().trim());
        System.out.println(dataTable.get("1 Artículo"));

    }

    public void clickBtnSuspender(){
        WebElement btnSuspender = driver.findElement(By.xpath("//div[@id='suspend_sale_button']"));
        clickbtn(btnSuspender);
    }

    public boolean isVisibleModalSuspendidas(){
        esperarElementoListo(modalVenatsSuspendidas, 10);
        return modalVenatsSuspendidas.isEnabled();
    }

    public void clickBtnRetomar(){
        esperarElementoListo(btnRetomar,10);
        btnRetomar.click();

    }

    public void clickbtnSuspendidas(){
        esperarElementoListo(btnSuspendidas,10);
        btnSuspendidas.click();

    }
}
