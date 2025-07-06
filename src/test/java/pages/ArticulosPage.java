package pages;

import base.BasePage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class ArticulosPage extends BasePage {

    private WebDriver driver;

    public ArticulosPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Ejemplo de elemento
    @FindBy(xpath = "//input[@id='name']")
    private WebElement inputNombreArticulo;

    @FindBy(xpath = "(//input[@id='category'])")
    private WebElement inputCategoria;

    @FindBy(xpath = "//input[@id='cost_price']")
    private WebElement inputPrecioPorMayor;

    @FindBy(xpath = "//input[@id='unit_price']")
    private WebElement inputPrecioDeVenta;

    @FindBy(xpath = "//input[@id='quantity_1']")
    private WebElement inputCantidadEnStock;

    @FindBy(xpath = "//input[@id='receiving_quantity']")
    private WebElement inputCantidadRecibida;

    @FindBy(xpath = "//input[@id='reorder_level']")
    private WebElement inputCantidadMinima;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement btnEnviar;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement alertaArticulo;

    @FindBy(xpath = "//a[@title='Actualizar Artículo']")
    private WebElement btnModificarArticulo;

    @FindBy(xpath = "//input[@name='btSelectItem']")
    private WebElement inputCheckbox;

    @FindBy(xpath = "//button[@id='delete']")
    private WebElement btnEliminar;



    public void agregarArticulo(Map<String, String> dataTable){
        waitForVisibility(inputNombreArticulo);
        inputNombreArticulo.sendKeys(dataTable.get("Nombre Articulo"));
        waitForVisibility(inputCategoria);
        inputCategoria.sendKeys(dataTable.get("Categoria"));
        waitForVisibility(inputPrecioPorMayor);
        inputPrecioPorMayor.sendKeys(dataTable.get("Precio al Por Mayor"));
        waitForVisibility(inputPrecioDeVenta);
        inputPrecioDeVenta.sendKeys(dataTable.get("Precio de Venta"));
        waitForVisibility(inputCantidadEnStock);
        inputCantidadEnStock.sendKeys(dataTable.get("Cantidad en Stock stock"));
        waitForVisibility(inputCantidadRecibida);
        inputCantidadRecibida.sendKeys(dataTable.get("Cantidad Recibida"));
        waitForVisibility(inputCantidadMinima);
        inputCantidadMinima.sendKeys(dataTable.get("Cantidad Minima"));
        waitForVisibility(btnEnviar);
        btnEnviar.click();
    }

    public String obtenerTextoAlerta(){
        esperarElementoListo(alertaArticulo, 10);
        String texto = alertaArticulo.getText();
        System.out.println(texto);
        return texto;

    }

    public void esperarYValidarArticuloFiltado(String textoEsperado, int segundos) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(segundos));

        wait.until(driver -> {
            try {
                WebElement primeraFila = driver.findElement(By.xpath("//table//tbody/tr[1]"));
                System.out.println(textoEsperado);
                return primeraFila.isDisplayed() && primeraFila.getText().contains(textoEsperado);
            } catch (StaleElementReferenceException e) {
                // Si el DOM se recargó, simplemente espera otra vez
                return false;
            }
        });

        WebElement primeraFilaFinal = getDriver().findElement(By.xpath("//table//tbody/tr[1]"));
        Assert.assertTrue("La primera fila no contiene el texto esperado: " + textoEsperado,
                primeraFilaFinal.getText().contains(textoEsperado));
    }

    public void clickBtnModificar(){
        waitForVisibility(btnModificarArticulo);
        clickbtn(btnModificarArticulo);
    }

    public void cambioDeCategoria(String categoriaNueva){
        esperarElementoListo(inputCategoria,10);
        inputCategoria.clear();
        inputCategoria.sendKeys(categoriaNueva);
        esperarElementoListo(btnEnviar,10);
        btnEnviar.click();
    }


    public void seleccionaryEliminarArticulo(){
        esperarElementoClickable(inputCheckbox, 10);
        clickbtn(inputCheckbox);
        esperarElementoClickable(btnEliminar, 10);
        clickbtn(btnEliminar);
        aceptarAlerta();
    }

}
