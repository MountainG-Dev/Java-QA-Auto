package Steps;

import Pages.Log4j;
import Util.driver.manager.driverManager;
import Util.driver.manager.driverManagerFactory;
import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import static Util.LeerProperty.*;

import java.io.FileNotFoundException;
import java.time.Duration;

public class Hooks{

    private static WebDriver driver;
    private driverManager driverManager;
    private static Logger logger = LogManager.getLogger(Hooks.class);

    public static WebDriver getDriver(){
        return driver;
    }

    @Before(order=1)
    public void beforeScenario() throws FileNotFoundException {

        logger.info("Start the browser and Clear the cookies");

        String navegador = leerProperties().getProperty("navegador").toLowerCase();
        String execution = leerProperties().getProperty("execution").toLowerCase();

        driverManager = driverManagerFactory.getManager(navegador, execution);
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Before(order=0)
    public void beforeScenarioStart(){

        logger.info("-----------------Start of Scenario-----------------");

    }

    @After(order=0)
    public void afterScenarioFinish(){

        logger.info("-----------------End of Scenario-----------------");
    }

    @After(order=1)
    public void afterScenario(){

        logger.info("Log out the user and close the browser");
        driver.quit();
    }


/*    @After
    public void TakeScreenShot(Scenario scenario){

        byte[] screenshotPass = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshotPass, "image/png", "Pass");

        if (scenario.isFailed()){
            byte[] screenshotFail = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotFail, "image/png", "Fail");
        }
    }*/
}
