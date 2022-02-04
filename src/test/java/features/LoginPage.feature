@LoginFeature
Feature: Prueba de Funcionalidad Login
  como usuario web, quiero ingresar con mis credenciales para poder ver mis pedidos.

Background: Usuario se logea
    Given un navegador web se abre en la página de prueba

  @SinginPassTest
  Scenario Outline: Verificar login con credenciales validas
    When se ingresa "<user>" en el campo usuario
    And se ingresa "<pass>" en el campo contraseña
    And se da click en el boton login
    Then el usuario "<user>" se logea
    And el usuario da click en la categoría monitores

    Examples: Credenciales
      | user         | pass |
      | prueba.27.11 | 123  |
      | prueba.26.11 | 123  |
      | prueba.25.11 | 123  |


#  @SinginFailTest
#  Scenario Outline: Verificar login con credenciales invalidas
#    When se ingresa "<user>" en el campo usuario invalido
#    And se ingresa "<pass>" en el campo contraseña invalida
#    Then debe aparece mensaje de contraseña incorrecta
#
#    Examples: Credenciales
#      | user    | pass |
#      | prueba1 | 123  |
#      | prueba2 | 123  |
#      | prueba3 | 123  |