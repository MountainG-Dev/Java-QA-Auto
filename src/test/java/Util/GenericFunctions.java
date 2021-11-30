/*
package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Steps.Hooks.*;

public class GenericFunctions {

    protected WebDriver driver;

    public GenericFunctions(){
        this.driver = getDriver();
    }

    public WebElement esperarElementoClickable(By byElement, int tiempo) {
        WebElement elemento = null;
        elemento = new WebDriverWait(driver, tiempo).until(ExpectedConditions.elementToBeClickable(byElement));
        return elemento;
    }


    public WebElement esperarElementoVisible(By byElement, int tiempo) {
        WebElement elemento = null;
        elemento = new WebDriverWait(driver, tiempo).until(ExpectedConditions.visibilityOfElementLocated(byElement));
        return elemento;
    }


    public boolean waitElementoVisible(WebElement elemento, int timeout) {
        Boolean isElementPresent = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            wait.until(ExpectedConditions.visibilityOf(elemento));
            isElementPresent = elemento.isDisplayed();
            return isElementPresent ;
        }catch (TimeoutException e) {
            System.out.println("No esta visible o no existe el elemento: " + elemento);
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean waitElementoClickable(WebElement elemento, int timeout) {
        Boolean isElementClicleable = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            wait.until(ExpectedConditions.elementToBeClickable(elemento));
            isElementClicleable = elemento.isDisplayed();
            return isElementClicleable ;
        }catch (TimeoutException e) {
            System.out.println("No elemento no clicleable: " + elemento);
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void waitSecuns(int segundos) {
        synchronized (driver) {
            try {
                driver.wait(segundos * 1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void ingresarTexto(WebElement elemento, String valor) {
        elemento.sendKeys(valor);
    }


    public void hacerClicElemento(WebElement elemento) {
        elemento.click();
    }

    public void moverHastaElemento(WebElement elemento){
        Actions builder = new Actions(driver);
        builder.moveToElement(elemento).build().perform();
    }

    public String textoDelElemento(WebElement elemento){
        return elemento.getText();
    }

    public void cambioDeIframe(WebElement elemento){
        driver.switchTo().frame(elemento);
    }

    public void defaultIframe(){
        driver.switchTo().defaultContent();
    }

    public void seleccionar(WebElement selectelement, String valor){
        Select select = new Select(selectelement);
        select.selectByVisibleText(valor);
    }

    public void seleccionar(By byElement, String valor){
        Select select = new Select(driver.findElement(byElement));
        select.selectByVisibleText(valor);
    }

    public void seleccionar(By byElement, int valor){
        Select selectSize = new Select(driver.findElement(byElement));
        selectSize.selectByIndex(valor);
    }

    public  void highlightRedElement(WebElement elemento){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;')", elemento);
    }

    public  void highlightGreenElement(WebElement elemento){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid green;')", elemento);
    }

    public  void scrollElement(WebElement elemento){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elemento);
    }

    */
/*
     * Validar ventana desplegable
     * *//*


    public boolean validarVentanaDesplegable() {
        String originalWindow = driver.getWindowHandle();
        if (driver.getWindowHandles().size() > 1) {
            for (String windowHandle : driver.getWindowHandles()) {
                if(!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    driver.manage().window().maximize();
                    break;
                }
            }
            return true;
        }else {
            return false;
        }
    }

    */
/*
     * mouseOver, realiza mousOver a elemento
     * *//*


    public void mouseOverElement (WebElement elemento) {
        try {
            String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                    "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                    "arguments[0].dispatchEvent(evObj);";
            ((JavascriptExecutor)driver).executeScript(javaScript, elemento);
            System.out.println("realizo mouseOvers");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
