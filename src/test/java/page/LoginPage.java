package page;

import steps.LoginSteps;

public class LoginPage extends BasePage {
    /*    @FindBy(how =How.XPATH, using = "//input[@title='Buscar']")
        WebElement campoBuscar;
    @FindBy(how =How.XPATH, using = "//div[@class='SDkEP']")
        WebElement btnBuscar;
    @FindBy(how =How.XPATH, using = "//title[normalize-space()='Google']")
        WebElement tituloHomePage;*/

    private final String sigInButton = "//a[normalize-space()='Log in']";
    private final String userUserField = "//div[@class='modal fade show']//input[@type='text']";
    private final String userPassField = "//div[@class='modal fade show']//input[@type='password']";
    private final String mointorCategory = "//a[4]";
    private final String logInButton = "//button[normalize-space()='Log in']";
    private final String userIsLogin= "//a[@id='nameofuser']";

    public LoginPage(){
        super(driver);
    }

    public void navigateToPage(){
        navigateTo("https://www.demoblaze.com/index.html");
    }

    public void clickSignIn(){
        clickElement(sigInButton);
    }

    public void clickLogIn(){
        clickElement(logInButton);
    }
    public void clickCategory(){
        clickElement(mointorCategory);
    }

    public void enterUser(String criteria){
        write(userUserField, criteria);
    }
    public void enterPass(String criteria){
        write(userPassField, criteria);
    }

    public String userVal(){
        return textFromElement(userIsLogin);
    }

/*    public boolean userLogIn(){
        return elementIsDisplayed(userIsDisplayed);
    }*/

}
