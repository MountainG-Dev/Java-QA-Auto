package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.genericFunctions;

import static java.nio.file.Files.write;

public class googlePage extends genericFunctions {

    @FindBy(how = How.XPATH, using = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[2]/div[5]/center[1]/input[1]")
    WebElement searchButton;
    @FindBy(how = How.XPATH, using = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
    WebElement searchTextField;
    @FindBy(how = How.XPATH, using = "//div[@id='cnt']")
    WebElement firstResults;
    @FindBy(how = How.XPATH, using = "//div[@id='cnt']")
    WebElement resultsDisplayed;

    public googlePage(WebDriver driver){
        super();
        PageFactory.initElements(driver, this);
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
