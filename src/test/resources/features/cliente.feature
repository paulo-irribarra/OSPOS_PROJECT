Feature: Cliente
  #Agregar un nuevo Cliente

  Background:
    Given Entro al portal "http://localhost/ospos/public/login"
    When ingresa usuario "Admin" y contraseña "pointofsale"
    And presiona el botón de ingresar
    And debería ver la página de inicio

  Scenario: Agregar Nuevo Cliente con los campos obligatorios
    And hacer click en la opcion "Clientes" en la barra horizontal
    And hacer click en el boton "Nuevo CLiente"
    And completo el formulario completo con todos los datos de forma correcta
      | Nombre   | Prueba Automatizada |
      | Apellido | Prueba Automatizada |

  Scenario: Buscar y editar un cliente
    And hacer click en la opcion "Clientes" en la barra horizontal
    And filtrar por nombre del cliente "Prueba Automatizada"
    And editar el apellido a "Prueba Editada"
    Then validar cambios realizados

  Scenario: Eliminar un cliente
    And hacer click en la opcion "Clientes" en la barra horizontal
    And filtrar por nombre del cliente "Prueba Editada"
    Then seleccionar cliente y eliminar





