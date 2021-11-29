package Util;

import Steps.Hooks;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.text.DateFormat;

public class Screenshot {

    private DateFormat dateFormat;
    private WebDriver driver;
    Logger logger = LogManager.getLogger(Hooks.class);

    public Screenshot(WebDriver driver){
        this.driver = driver;
    }

    public void TakeScreenShot(Scenario scenario){

            byte[] screenshotonPass = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotonPass, "image/png", "Pass");
            if (scenario.isFailed()){
                byte[] screenshotFail = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshotFail, "image/png", "Failed");
            }
    }
}
