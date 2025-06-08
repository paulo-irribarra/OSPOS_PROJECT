Feature: Login
  # LOGIN EXITOSO
  Scenario Outline: Login con diferentes credenciales
    Given Entro al portal "http://localhost/ospos/public/login"
    When ingresa usuario "<usuario>" y contraseña "<clave>"
    And presiona el botón de login
    Then debería ver la página de inicio

    Examples:
      | usuario | clave       |
      | admin   | pointofsale |

  # LOGIN INCORRECTO
  Scenario: Login con Contraseña invalida
    Given Entro al portal "http://localhost/ospos/public/login"
    When ingresa usuario "admin" y contraseña "CryBaby"
    Then validar el mensaje de login incorrecto