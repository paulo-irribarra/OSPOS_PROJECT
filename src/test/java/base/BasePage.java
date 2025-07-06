package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class BasePage {

    private static WebDriver driver;
    protected WebDriverWait wait;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // espera de 10 seg
    }

    // CLICK PASANDO UN WEBELEMENT POR PARAMETRO
    protected void click(WebElement element) {
        waitForVisibility(element).click();
    }

    // Inicializa el driver si aún no existe
    public static void initializeDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    // Devuelve el driver actual
    public static WebDriver getDriver() {
        return driver;
    }

    // Cierra y limpia el driver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // Espera a que un elemento esté visible (por WebElement)
    protected WebElement waitForVisibility(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            throw new RuntimeException("Elemento no visible después del tiempo de espera: " + element, e);
        }
    }

    protected WebElement waitForVisibility(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            throw new RuntimeException("Elemento no localizado: " + locator, e);
        }
    }

    public void hacerClickEnElBotonNuevaOpcion(String crear) {
        String xpath = "//button[@title='"+crear+"']";
        WebElement btncrear = driver.findElement(By.xpath(xpath));
        btncrear.click();
    }

    public void FiltrarMenu(String opcion){
        By inputBuscar = By.xpath("//input[@placeholder='Buscar']");
        WebElement campo = esperarElementoClickable(inputBuscar,10);
        campo.clear();
        campo.sendKeys(opcion);
    }

    public void clickbtn(WebElement webElement){
        webElement.click();
    }

    protected WebElement esperarElementoClickable(By locator, int segundos) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(segundos));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement esperarElementoClickable(WebElement element, int segundos) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(segundos));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void esperarElementoListo(WebElement element, int segundos) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(segundos));

        wait.until(driver -> {
            try {
                return (element.isDisplayed() && element.isEnabled()) ? element : null;
            } catch (StaleElementReferenceException e) {
                return null; // Si el DOM se actualizó, seguirá esperando
            }
        });
    }

    public void aceptarAlerta(){
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }







}
