package stepdefinition;

import base.BasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.ArticulosPage;
import pages.ClientesPage;

import java.util.Map;

public class ArticulosDefinition {

    private ArticulosPage articulosPage = new ArticulosPage(BasePage.getDriver());

    @And("completo el formulario completo de articulos con todos los datos de forma correcta")
    public void completoElFormularioCompletoDeArticulosConTodosLosDatosDeFormaCorrecta(DataTable dataTable) {
        Map<String, String> datos = dataTable.asMap();
        articulosPage.agregarArticulo(datos);

    }

    @Then("valido la creacion del nuevo articulo")
    public void validoLaCreacionDelNuevoArticulo() {
        //Assert.assertTrue("No se visualiza la alerta de artículo creado correctamente",articulosPage.isVisibleAlertaNuevoArticulo());

    }

    @And("filtrar por nombre de articulo {string}")
    public void filtrarPorNombreDeArticulo(String nombreArticulo) {
        articulosPage.FiltrarMenu(nombreArticulo);
        articulosPage.esperarYValidarArticuloFiltado(nombreArticulo, 10);

    }


    @And("editar la categoria a {string}")
    public void editarLaCategoriaA(String categoriaEditada) {
        articulosPage.clickBtnModificar();
        articulosPage.cambioDeCategoria(categoriaEditada);

    }

    @Then("valido la edicion del articulo")
    public void validoLaEdicionDelArticulo() {
        //Assert.assertTrue("No se visualiza la alerta de artículo creado correctamente",articulosPage.isVisibleAlertaNuevoArticulo());
    }

    @And("valido la {string} del articulo")
    public void validoLaDelArticulo(String accion) {
        switch (accion.toLowerCase()) {
            case "creacion":
                Assert.assertEquals("×\n" +"Has agregado satisfactoriamente un artículo Prueba Automatizada",articulosPage.obtenerTextoAlerta());
                break;
            case "edicion":
                Assert.assertEquals("×\n" + "Has actualizando satisfactoriamente un artículo Prueba Automatizada", articulosPage.obtenerTextoAlerta());
                break;
            case "eliminacion":
                Assert.assertEquals("×\n" + "Has borrado satisfactoriamente 1 articulo(s)",articulosPage.obtenerTextoAlerta() );
                break;

        }

    }

    @And("Seleccionar y eliminar articulo")
    public void seleccionarYEliminarArticulo() {
        articulosPage.seleccionaryEliminarArticulo();

    }
}
