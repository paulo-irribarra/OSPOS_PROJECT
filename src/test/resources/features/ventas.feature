Feature: TC Módulo Ventas

  Background:
    Given Entro al portal "http://localhost/ospos/public/login"
    When ingresa usuario "Admin" y contraseña "pointofsale"
    And presiona el botón de ingresar
    And debería ver la página de inicio

  Scenario: Realiza una venta sin cliente
    And hacer click en la opcion "Ventas" en la barra horizontal
    And realizar una venta de un articulo
      | Nombre Articulo |        |
      | 1 Artículo      | RAM001 |
      | 2 Artiículo     | GPU001 |
      | 3 Artículo      | CPU001 |
    Then se valida la boleta creada




