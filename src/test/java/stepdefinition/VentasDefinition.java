package stepdefinition;

import base.BasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ArticulosPage;
import pages.VentasPage;

import java.util.Map;

public class VentasDefinition {

    private VentasPage ventasPage = new VentasPage(BasePage.getDriver());

    @And("realizar una venta de un articulo")
    public void realizarUnaVentaDeUnArticulo(DataTable dataTable) {
        Map<String, String> datos = dataTable.asMap();
        ventasPage.agregraArticuloAlCarrito(datos);
    }

    @Then("se valida la boleta creada")
    public void seValidaLaBoletaCreada() {
        Assert.assertTrue("No se visualiza la boleta", ventasPage.isVisibleidBoleta());

    }
}
