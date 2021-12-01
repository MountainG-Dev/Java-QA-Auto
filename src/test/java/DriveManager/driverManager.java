package DriveManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class driverManager {

    protected static WebDriver driver;

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
