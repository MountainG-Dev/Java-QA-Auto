package Steps;

import io.cucumber.java.en.*;

public class LoginSteps {

    @Given("un navegador web se abre en la página de prueba")
    public void un_navegador_web_se_abre_en_la_página_de_prueba() {
        System.out.println("Paso 001 - se ingresa pass invalida en el campo contraseña");
    }
    @When("se ingresa {string} en el campo usuario")
    public void se_ingresa_en_el_campo_usuario(String string) {
        System.out.println("Paso 002 - Se ingresa user valido en el campo usuario");
    }
    @And("se ingresa {string} en el campo contraseña")
    public void se_ingresa_en_el_campo_contraseña(String string) {
        System.out.println("Paso 003 - Se ingresa pass valida en el campo contraseña");
    }
    @Then("se ingresa al menú de usuario")
    public void se_ingresa_al_menú_de_usuario() {
        System.out.println("Paso 004 - Se ingresa pass invalida en el campo contraseña");
    }
    @And("se da click en la categoría monitores")
    public void se_da_click_en_la_categoría_monitores() {
        System.out.println("Paso 005 - se da click en la categoria monitores");
    }
    @When("se ingresa {string} en el campo usuario invalido")
    public void se_ingresa_en_el_campo_usuario_invalido(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("se ingresa {string} en el campo contraseña invalida")
    public void se_ingresa_en_el_campo_contraseña_invalida(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("debe aparece mensaje de contraseña incorrecta")
    public void debe_aparece_mensaje_de_contraseña_incorrecta() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
