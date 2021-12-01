package runner;

import page.BasePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"steps"},
        plugin = {"json:test-output/Json-Report/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        tags = "@FunctionalTest"
)
public class TestRunner {
    @AfterClass
    public static void cleanDriver(){
        BasePage.closeDriver();
    }
}
