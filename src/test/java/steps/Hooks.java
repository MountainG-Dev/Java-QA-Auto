package steps;

import page.BasePage;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends BasePage{

    public Hooks() {
        super(driver);
    }

    @AfterStep
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshotFail = ((TakesScreenshot)driver)
                        .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotFail, "image/png", "Failed");
        }else {
            final byte[] screenshotonPass = ((TakesScreenshot)driver)
                        .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotonPass, "image/png", "Pass");
        }
    }


}
