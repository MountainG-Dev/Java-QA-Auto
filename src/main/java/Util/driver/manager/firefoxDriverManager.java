package Util.driver.manager;

import org.openqa.selenium.firefox.FirefoxDriver;

public class firefoxDriverManager extends driverManager{

    @Override
    public void createDriver() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/Drivers/chromedriver.exe");
        driver = new FirefoxDriver();
    }
}
