package Steps;

import Util.driver.manager.driverManager;
import Util.driver.manager.driverManagerFactory;
import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import static Util.LeerProperty.*;
import java.time.Duration;

public class Hooks{

    private static WebDriver driver;
    private driverManager driverManager;
    private static Logger logger = LogManager.getLogger(Hooks.class);

    public static WebDriver getDriver(){
        return driver;
    }

    @AfterStep
    public void take(Scenario scenario){
        byte[] screenshotonPass = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshotonPass, "image/png", "Pass");

        if (scenario.isFailed()){
            byte[] screenshotFail = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotFail, "image/png", "Failed");
        }
    }

    @Before(order=0)
    public void beforeScenarioStart(){

        System.out.println("-----------------Start of Scenario-----------------");
    }

    @Before(order=1)
    public void beforeScenario() throws Exception {

        System.out.println("Start the browser and Clear the cookies");

        String navegador = leerProperties().getProperty("navegador").toLowerCase();
        String execution = leerProperties().getProperty("execution").toLowerCase();

        driverManager = driverManagerFactory.getManager(navegador, execution);
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @After(order=1)
    public void afterScenario(){

        System.out.println("Log out the user and close the browser");
        driver.close();
    }

    @After(order=0)
    public void afterScenarioFinish(){

        System.out.println("-----------------End of Scenario-----------------");
        driver.quit();
    }



}
