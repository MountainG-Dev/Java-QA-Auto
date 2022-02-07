package runner;

import driver.manager.baseFlowDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/GoogleSearch.feature",
        glue = {"steps"},
        plugin = {"json:test-output/Json-Report/ExtentJson.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@GoogleFeature"
        //monochrome = true,
)
public class testRunner extends baseFlowDriver {
    @AfterClass
    public static void writeExtentReport() throws IOException {
       // ** Limpia la instancia de WebDriver a nivel S.O. **
       Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
       driver.quit();
    }
}
