Feature: Cliente

  Background:
    Given Entro al portal "http://localhost/ospos/public/login"
    When ingresa usuario "Admin" y contraseña "pointofsale"
    And presiona el botón de ingresar
    And debería ver la página de inicio

  Scenario: Agregar Nuevo Articulo con los campos obligatorios
    And hacer click en la opcion "Artículos" en la barra horizontal
    And hacer click en el boton "Nuevo Artículo"
    And completo el formulario completo de articulos con todos los datos de forma correcta
      | Nombre Articulo         | Prueba Automatizada |
      | Categoria               | Prueba Automatizada |
      | Precio al Por Mayor     | 100                 |
      | Precio de Venta         | 115                 |
      | Cantidad en Stock stock | 1                   |
      | Cantidad Recibida       | 1                   |
      | Cantidad Minima         | 1                   |
    Then valido la "creacion" del articulo

  Scenario: Filtrar y editar un articulo
    And hacer click en la opcion "Artículos" en la barra horizontal
    And filtrar por nombre de articulo "Prueba Automatizada"
    And editar la categoria a "Prueba Editar"
    And valido la "edicion" del articulo

  Scenario: Filtrar y eliminar un articulo
    And hacer click en la opcion "Artículos" en la barra horizontal
    And filtrar por nombre de articulo "Prueba Editar"
    And Seleccionar y eliminar articulo
    And valido la "eliminacion" del articulo




