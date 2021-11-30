package Steps;

import Pages.GooglePage;
import io.cucumber.java.en.*;
import org.junit.Assert;

@SuppressWarnings("ALL")
public class GoogleSteps extends GooglePage {

    GooglePage google = new GooglePage();

    @Given("un navegador web se abre en la página de Google")
    public void un_navegador_web_se_abre_en_la_página_de_google() throws Throwable {
        System.out.println("Paso 001 - Un navegador web en la página de Google");
        try{
            google.navigateToGoogle();
        }catch (AssertionError e){
            throw new Exception("Falló al intentar navegar a Google");
        }
    }
    @When("se introduce la palabra de búsqueda {string}")
    public void se_introduce_la_palabra_de_búsqueda(String frase) throws Throwable{
        System.out.println("Paso 002 - Se introduce la palabra de búsqueda");
        try{
            google.enterSearchCriteria(frase);
        }catch (AssertionError e){
            throw new Exception("Falló al intentar introducir la palabra de búsqueda");
        }
    }

    @And("se presiona el botón enter")
    public void se_presiona_el_botón_enter() throws Throwable{
        System.out.println("Paso 003 - Se presiona el botón enter");
        try{
            google.clickGoogleSearch();
        }catch (AssertionError e){
            throw new Exception("Falló al intentar presionar el botón buscar");
        }
    }
    @Then("se muestra el resultado de {string}")
    public void se_muestra_el_resultado_de(String frase) throws Throwable{
        System.out.println("Paso 004 - Se muestra el resultado");
        try{
            Assert.assertTrue(frase, google.pageResult());
        }catch (AssertionError e){
            throw new Exception("Falló al intentar mostrar el resultado frase");
        }
    }
    @And("los resultados relacionados {string}")
    public void los_resultados_relacionados(String relacionado) throws Throwable{
        System.out.println("Paso 005 - Los resultados relacionados");
        try{
            Assert.assertTrue(relacionado, google.pageResult());
        }catch (AssertionError e){
            throw new Exception("Falló al intentar mostrar el resultado relacionado");
        }
    }

}
