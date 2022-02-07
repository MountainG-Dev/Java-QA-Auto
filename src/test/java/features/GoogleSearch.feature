Feature: Búsqueda en Google


  Scenario Outline: Búsqueda simple en Google
    Given un navegador web se abre en la página de Google
    When se introduce la palabra de búsqueda <frase>
    And se presiona el botón enter
    And se muestra el resultado de <frase>
    Then los resultados relacionados <relacionado>

    @GoogleFeature
    Examples:
    | frase      | relacionado          |
    | "pingüino" | "Pingüino emperador" |
    | "panda"    | "Panda gigante"      |
    | "elefante" | "Elefante africano"  |
    | "Pato"     | "Pato Branco"        |