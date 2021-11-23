package Steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleSearchSteps extends BaseSteps {

    @Given("un navegador web se abre en la página de Google")
    public void un_navegador_web_se_abre_en_la_página_de_google() {

        System.out.println("Paso 001 - Un navegador web en la página de Google");

        driver.navigate().to("https://www.google.com/?hl=es");
    }
    @When("se introduce la palabra de búsqueda {string}")
    public void se_introduce_la_palabra_de_búsqueda(String string) {
        System.out.println("Paso 002 - Se introduce la palabra de búsqueda");

        driver.findElement(By.name("q")).sendKeys(string);
    }

    @And("se presiona el botón enter")
    public void se_presiona_el_botón_enter() {
        System.out.println("Paso 003 - Se presiona el botón enter");

        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }
    @Then("se muestra el resultado de {string}")
    public void se_muestra_el_resultado_de(String string) {
        System.out.println("Paso 004 - Se muestra el resultado");

        driver.getPageSource().contains(string);
    }
    @And("los resultados relacionados {string}")
    public void los_resultados_relacionados(String string) {
        System.out.println("Paso 005 - Los resultados relacionados");

        driver.getPageSource().contains(string);
        driver.close();
        driver.quit();
    }

}
