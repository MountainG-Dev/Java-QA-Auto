package steps;

import driver.manager.baseFlowDriver;
import io.cucumber.java.AfterStep;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class afterFlow extends baseSteps{

    @AfterStep
    public void screenShotDown(Scenario scenario) throws Exception {
        if (scenario.isFailed()){
            final byte[] screenshotFail = ((TakesScreenshot)baseFlowDriver.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotFail, "image/png", "Failed");
        }else {
            final byte[] screenshotonPass = ((TakesScreenshot)baseFlowDriver.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotonPass, "image/png", "Pass");
        }
   }

}