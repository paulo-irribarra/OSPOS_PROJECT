package stepdefinition;

import base.BasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ArticulosPage;
import pages.VentasPage;

import java.util.Map;

public class VentasDefinition {

    private VentasPage ventasPage = new VentasPage(BasePage.getDriver());

    @And("realizar una venta de un articulo")
    public void realizarUnaVentaDeUnArticulo(DataTable dataTable) {
        Map<String, String> datos = dataTable.asMap();
        ventasPage.realizarVenta(datos);
    }

    @Then("se valida la boleta creada")
    public void seValidaLaBoletaCreada() {
        Assert.assertTrue("No se visualiza la boleta", ventasPage.isVisibleidBoleta());

    }

    @And("ingresar un articulo al carro")
    public void ingresarUnArticuloAlCarro(DataTable dataTable) {
        Map<String, String> datos = dataTable.asMap();
        ventasPage.agregarArticuloAlCarro(datos);

    }

    @When("hago click en el btn suspender")
    public void hagoClickEnElBtnSuspender() {
        ventasPage.clickBtnSuspender();
    }

    @And("validar el modal de ventas suspendidas")
    public void validarElModalDeVentasSuspendidas() {
        Assert.assertTrue("No se visualiza el modal de ventas suspendidas", ventasPage.isVisibleModalSuspendidas());

    }

    @And("retomar una venta suspendida")
    public void remotarUnaVentaSuspendida() {
        ventasPage.clickBtnRetomar();
    }

    @And("hago click en el btn suspendidas")
    public void hagoClickEnElBtnSuspendidas() {
        ventasPage.clickbtnSuspendidas();
    }
}
