package Common;

import Steps.BaseSteps;
import Steps.Hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static Steps.Hooks.*;

public class GenericFunctions{
    private static WebDriver driver;

    public GenericFunctions(){
        this.driver = getDriver();
    }

/*    public static byte[] getByteScreenshot() throws IOException {
        File screenshotonPass = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        byte [] fileContent = FileUtils.readFileToByteArray(screenshotonPass);
        return fileContent;
    }*/
}
