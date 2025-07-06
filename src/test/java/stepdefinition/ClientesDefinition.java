package stepdefinition;

import base.BasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ClientesPage;

import javax.xml.crypto.Data;
import java.util.Map;

public class ClientesDefinition {

    private ClientesPage clientesPage = new ClientesPage(BasePage.getDriver());

    @And("hacer click en el boton {string}")
    public void hacerClickEnElBoton(String btnNuevoCliente) {
        clientesPage.clickBtnAgregarCliente();
        Assert.assertTrue("No se logra visualizar el formulario para crear un cliente", clientesPage.isVisibleTituloFormulario());
    }

    @And("completo el formulario completo con todos los datos de forma correcta")
    public void completoElFormularioCompletoConTodosLosDatosDeFormaCorrecta(DataTable dataTable) {
        Map<String, String> datos = dataTable.asMap();
        clientesPage.agregarNuevoClienteFormaliario(datos);
        clientesPage.isVisibleAlertaUsuarioCreado();
    }

    @And("Buscar un cliente {string}")
    public void buscarUnCliente(String cliente) {
        clientesPage.buscarCliente(cliente);

    }

    @And("filtrar por nombre del cliente {string}")
    public void filtrarPorNombreDelCliente(String nombreCliente) {
        clientesPage.buscarCliente(nombreCliente);

    }

    @And("editar el apellido a {string}")
    public void editarElApellidoA(String apellidoEditado) {
        clientesPage.esperarfiltradoCliente();
        clientesPage.clickBtnEditar();
        clientesPage.editarCliente(apellidoEditado);

    }

    @And("validar cambios realizados")
    public void validarCambiosRealizados() {
        clientesPage.esperarTextoEnFila("Prueba Editada", 10);
        Assert.assertEquals("Prueba Editada", clientesPage.getTextFilaClientes());
        System.out.println(clientesPage.getTextFilaClientes());
    }


    @Then("seleccionar cliente y eliminar")
    public void seleccionarClienteYEliminar() {
        clientesPage.esperarfiltradoCliente();
        clientesPage.eliminarCliente();
    }
}
