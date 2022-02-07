package steps;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class googleSteps extends baseSteps{

    static Logger logger = LogManager.getLogger(Log4j.class);

    @Given("un navegador web se abre en la página de Google")
    public void un_navegador_web_se_abre_en_la_página_de_google() throws Throwable {
        System.out.println("Paso 001 - Un navegador web en la página de Google");
        try{
            google_Page.navigateToGoogle();
        }catch (AssertionError e){
            throw new Exception("Falló al intentar navegar a Google");
        }
    }
    @When("se introduce la palabra de búsqueda \"([^\"]*)\"$")
    public void se_introduce_la_palabra_de_búsqueda(String frase) throws Throwable{
        System.out.println("Paso 002 - Se introduce la palabra de búsqueda");
        try{
            google_Page.enterSearchCriteria(frase);
            }catch (AssertionError e){
                throw new Exception("Falló al intentar introducir la palabra de búsqueda");
            }
    }

    @And("se presiona el botón enter")
    public void se_presiona_el_botón_enter() throws Throwable{
        System.out.println("Paso 003 - Se presiona el botón enter");
        try{
            google_Page.clickGoogleSearch();
        }catch (AssertionError e){
            throw new Exception("Falló al intentar presionar el botón buscar");
        }
    }
    @And("se muestra el resultado de \"([^\"]*)\"$")
    public void se_muestra_el_resultado_de(String frase) throws Throwable{
        System.out.println("Paso 004 - Se muestra el resultado");
        try{
            Assert.assertTrue(google_Page.firstResult().contains(frase));
        }catch (AssertionError e){
            throw new Exception("Falló al intentar mostrar el resultado frase");
        }
    }
    @Then("los resultados relacionados \"([^\"]*)\"$")
    public void los_resultados_relacionados(String relacionado) throws Throwable{
        System.out.println("Paso 005 - Los resultados relacionados");
        try{
            Assert.assertTrue(google_Page.firstResult().contains(relacionado));
        }catch (AssertionError e){
            throw new Exception("Falló al intentar mostrar el resultado relacionado");
        }
    }
}
