package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    /* Método que instancia el WebDriver */
    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        driver  = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    /* Constructor de clase que espera la instancia del WebDriver */
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    /* Método para navegar a URL */
    public static void navigateTo(String url){
        driver.get(url);
    }
    /* Método para finalizar la instancia del Webdriver */
    public static void closeDriver(){
        driver.quit();
    }
    /* Método para abrir nueva ventana */
    public static void openWindow(){
        driver.switchTo().newWindow(WindowType.WINDOW);
    }
    /* Método para obtener WebElement */
    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
    /* Método para hacer clic en WebElement */
    public void clickElement(String locator){
        Find(locator).click();
    }
    /* Método para obtener TextField */
    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }
    /* Método para obtener dropdown por valor */
    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByValue(valueToSelect);
    }
    /* Método para obtener dropdown por index */
    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByIndex(valueToSelect);
    }
    /* Método para obtener dropdown por texto */
    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByVisibleText(valueToSelect);
    }
    /* Método para realizar un sobre el elemento */
    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }
    /* Método para realizar doble clic sobre el elemento */
    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }
    /* Método para realizar clic derecho sobre el elemento */
    public void rightClick(String locator){
        action.contextClick(Find(locator));
    }
    /* Método para obtener texto desde una tabla */
    public String getValueFromTable(String locator, int row, int column){
        String cellINeed = locator + "/table/tbody/tr["+row+"]/td["+column+"]";

        return Find(cellINeed).getText();
    }
    /* Método para setear texto en una tabla */
    public void setValueFromTable(String locator, int row, int column, String stringToSend){
        String cellToFill = locator + "/table/tbody/tr["+row+"]/td["+column+"]";

        Find(cellToFill).sendKeys(stringToSend);
    }
    /* Método para cambiar entre IFrame */
    public void switchToiFrame(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }
    /* Método para volver al iFrame padre*/
    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }
    /* Método para rechazar alertas */
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    /* Método para obtener texto desde un WebElement */
    public String textFromElement(String locator){
        return Find(locator).getText();
    }
    /* Método para validar que un WebElement es mostrado*/
    public boolean elementIsDisplayed(String locator){
        return Find(locator).isDisplayed();
    }
    /* Método para validar que un WebElement está habilitado para ser cliqueado */
    public boolean elementIsEnable(String locator){
        return Find(locator).isEnabled();
    }
    /* Método para validar que un WebElement en un dropdown o checkboxes esté seleccionado */
    public boolean elementIsSelected(String locator){
        return Find(locator).isSelected();
    }
    /* Método para obtener todos los WebElement de una lista */
    public List<WebElement> bringMeAllElements(String locator){
        return driver.findElements(By.className(locator));
    }
}
