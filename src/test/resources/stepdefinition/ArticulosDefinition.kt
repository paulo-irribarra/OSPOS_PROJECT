package stepdefinition

import io.cucumber.datatable.DataTable
import io.cucumber.java.en.And

class ArticulosDefinition {

    @And("completo el formulario completo con todos los datos de forma correcta")
    fun completoElFormularioCompletoConTodosLosDatosDeFormaCorrecta(dataTable: DataTable) {

        clientesPage.agregarNuevoClienteFormaliario(datos)
        clientesPage.isVisibleAlertaUsuarioCreado()
    }
}