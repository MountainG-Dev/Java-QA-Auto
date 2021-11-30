package Steps;

import Pages.BasePage;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends BasePage{

    public Hooks() {
        super(driver);
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
    public void beforeScenario(){

        System.out.println("Start the browser and Clear the cookies");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @After(order=1)
    public void afterScenario(){

        System.out.println("Log out the user and close the browser");
    }

    @After(order=0)
    public void afterScenarioFinish(){

        System.out.println("-----------------End of Scenario-----------------");
    }
}
