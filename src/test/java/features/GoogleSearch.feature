@GoogleFeature
Feature: Búsqueda en Google


  @SmokeTest @RegressionTest
  Scenario Outline: Búsqueda simple en Google
    Given un navegador web se abre en la página de Google
    When se introduce la palabra de búsqueda "<frase>"
    And se presiona el botón enter
    Then se muestra el resultado de "<frase>"
    And los resultados relacionados "<relacionado>"

    Examples: Animales
      | frase    | relacionado        |
      | pingüino | Pingüino emperador |
      | panda    | Panda gigante      |
      | elefante | Elefante africano  |