package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GooglePage extends BasePage{

/*    @FindBy(how =How.XPATH, using = "//input[@title='Buscar']")
        WebElement campoBuscar;
    @FindBy(how =How.XPATH, using = "//div[@class='SDkEP']")
        WebElement btnBuscar;
    @FindBy(how =How.XPATH, using = "//title[normalize-space()='Google']")
        WebElement tituloHomePage;*/

    private String searchButton = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[2]/div[5]/center[1]/input[1]";
    private String searchTextField = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]";
    private String firstResults = "//div[@id='rso']";
    private String resultsDisplayed = "//div[@id='rso']";

    public GooglePage(){
        super(driver);
    }

    public void navigateToGoogle(){
        navigateTo("https://www.google.com/?hl=es");
    }

    public void clickGoogleSearch(){
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria){
        write(searchTextField, criteria);
    }

    public String firstResult(){
        return textFromElement(firstResults);
    }

    public boolean pageResult(){
        return elementIsDisplayed(resultsDisplayed);
    }
}
