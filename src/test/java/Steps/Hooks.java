package Steps;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import Util.driver.manager.*;
import static Util.LeerProperty.*;

import java.io.FileNotFoundException;
import java.time.Duration;

public class Hooks{

    private static WebDriver driver;
    private driverManager driverManager;

    public static WebDriver getDriver(){
        return driver;
    }

    @Before(order=1)
    public void beforeScenario() throws FileNotFoundException {
        System.out.println("Start the browser and Clear the cookies");

        String navegador = leerProperties().getProperty("navegador").toLowerCase();
        String execution = leerProperties().getProperty("execution").toLowerCase();

        driverManager = driverManagerFactory.getManager(navegador, execution);
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }
    @Before(order=0)
    public void beforeScenarioStart(){
        System.out.println("-----------------Start of Scenario-----------------");

    }
    @After(order=0)
    public void afterScenarioFinish(){
        System.out.println("-----------------End of Scenario-----------------");
    }
    @After(order=1)
    public void afterScenario(){
        System.out.println("Log out the user and close the browser");
        driver.manage().deleteAllCookies();
        driver.close();
        driverManager.quitDriver();
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
