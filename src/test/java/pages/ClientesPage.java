package pages;

import base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class ClientesPage extends BasePage {

    private WebDriver driver;

    public ClientesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Ejemplo de elemento
    @FindBy(xpath = "//button[@title='Nuevo Cliente']")
    private WebElement btnAgregarCliente;

    @FindBy(xpath = "//div[contains(text(), 'Nuevo Cliente')]")
    private WebElement tituloFormulario;

    @FindBy(xpath = "//*[@id=\"first_name\"]")
    private WebElement inputNombre;

    @FindBy(xpath = "(//input[@id='last_name'])[1]")
    private WebElement inputApellido;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement alertaUsuarioCreado;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement btnEnviar;

    @FindBy(xpath = "//input[@placeholder='Buscar']")
    private WebElement inputBuscar;

    @FindBy(xpath = "//span[@class='glyphicon glyphicon-edit']")
    private WebElement btnEditar;

    @FindBy(xpath = "//input[@name='btSelectItem']")
    private WebElement inputCheckBox;

    @FindBy(xpath = "//button[@id='delete']")
    private WebElement btnEliminar;

    // Acción segura usando la espera
    public void clickBtnAgregarCliente() {
        waitForVisibility(btnAgregarCliente);
        btnAgregarCliente.click();
    }

    public boolean isVisibleTituloFormulario(){
        waitForVisibility(tituloFormulario);
        return tituloFormulario.isEnabled();
    }

     public void agregarNuevoClienteFormaliario(Map<String, String> datos){
        inputNombre.sendKeys(datos.get("Nombre"));
        inputApellido.sendKeys(datos.get("Apellido"));
        btnEnviar.click();
     }

     public void isVisibleAlertaUsuarioCreado(){
        waitForVisibility(alertaUsuarioCreado);
        String mensajeAlerta = alertaUsuarioCreado.getText();
         System.out.println(mensajeAlerta);
     }

     public void buscarCliente(String cliente){
        waitForVisibility(inputBuscar);
        inputBuscar.click();
        inputBuscar.sendKeys(cliente);
     }

     public boolean isVisibleClienteFiltrado(){
        String apellido = "Prueba Automatizada";
        String xpath = "(//td[contains(text(),'"+apellido+"')])[1]";
        waitForVisibility(By.xpath(xpath));
        System.out.println(By.xpath(xpath));
        return driver.findElement(By.xpath(xpath)).isEnabled();

    }

     public void editarCliente(String apellido){
        waitForVisibility(inputApellido);
        inputApellido.clear();
        inputApellido.sendKeys(apellido);
        waitForVisibility(btnEnviar);
        btnEnviar.click();
     }

     public String getTextFilaClientes(){
        String xpath = "(//td[contains(text(),'Prueba Editada')])";
        return driver.findElement(By.xpath(xpath)).getText();
     }

    public void esperarfiltradoCliente() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String text = "Prueba Automatizada";
        // Esperar hasta que la tabla tenga solo una fila visible con el texto deseado
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath("(//td[contains(text(),'"+text+"')])[1]"), text
        ));

        // Asegurarse de que solo hay una fila visible (mejor aún)
        wait.until(driver -> {
            List<WebElement> filasVisibles = driver.findElements(By.xpath("//table//tbody/tr[not(contains(@style,'display: none'))]"));
            return filasVisibles.size() == 1;
        });

    }

    public void clickBtnEditar(){
        waitForVisibility(btnEditar);
        btnEditar.click();
    }

    public void esperarTextoEnFila(String textoEsperado, int segundos) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(segundos));
        wait.until(driver -> getTextFilaClientes().contains(textoEsperado));
    }

    public void eliminarCliente(){
        waitForVisibility(inputCheckBox);
        inputCheckBox.click();
        waitForVisibility(btnEliminar);
        btnEliminar.click();
        aceptarAlerta();
    }



}
