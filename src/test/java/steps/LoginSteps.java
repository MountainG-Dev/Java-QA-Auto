package steps;

import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import page.LoginPage;
import util.Log4j;

@SuppressWarnings("ALL")
public class LoginSteps {

    LoginPage login = new LoginPage();
    static Logger logger = LogManager.getLogger(Log4j.class);

    @Given("un navegador web se abre en la página de prueba")
    public void un_navegador_web_se_abre_en_la_página_de_prueba() throws Throwable{
        System.out.println("Paso 001 - se ingresa pass invalida en el campo contraseña");
        try{
            login.navigateToPage();
        }catch (AssertionError e){
            throw new Exception("Falló al intentar navegar a la página de pruebas");
        }
    }
    @When("se ingresa {string} en el campo usuario")
    public void se_ingresa_en_el_campo_usuario(String user) throws Throwable {
        System.out.println("Paso 002 - Se ingresa user valido en el campo usuario");
        try{
            login.clickSignIn();
            login.enterUser(user);
        }catch (AssertionError e){
            throw new Exception("Falló al intentar ingresar el usuario");
        }
    }
    @And("se ingresa {string} en el campo contraseña")
    public void se_ingresa_en_el_campo_contraseña(String pass) throws Throwable{
        System.out.println("Paso 003 - Se ingresa pass valida en el campo contraseña");
        try{
            login.enterPass(pass);
        }catch (AssertionError e){
            throw new Exception("Falló al intentar ingresar la contraseña");
        }
    }
    @And("se da click en el boton login")
    public void se_da_click_en_el_boton_login() throws Throwable{
        System.out.println("Paso 004 - Se da click en el botón log in");
        try{
            login.clickLogIn();
        }catch (AssertionError e){
            throw new Exception("Falló al intentar navegar a la página de pruebas");
        }
    }
    @Then("el usuario {string} se logea")
    public void el_usuario_se_logea(String user) throws Throwable{
        System.out.println("Paso 005 - El usuario se logea correctamente");
        try{
            Assert.assertTrue(login.userVal().contains(user));
        }catch (AssertionError e){
            throw new Exception("Falló al intentar navegar a la página de pruebas");
        }
    }
    @And("el usuario da click en la categoría monitores")
    public void el_usuario_da_click_en_la_categoría_monitores() throws Throwable{
        System.out.println("Paso 006 - El usuario selecciona la caterogoria monitores");
        try{
            login.clickCategory();
        }catch (AssertionError e){
            throw new Exception("Falló al intentar navegar a la página de pruebas");
        }
    }
}
