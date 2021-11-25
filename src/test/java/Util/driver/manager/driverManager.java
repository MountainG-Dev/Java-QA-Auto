package Util.driver.manager;

import org.openqa.selenium.WebDriver;

public abstract class driverManager {

    protected WebDriver driver;

    public abstract void createDriver();

    public void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver(){

        if (driver == null){
            createDriver();
        }
        return driver;
    }

}