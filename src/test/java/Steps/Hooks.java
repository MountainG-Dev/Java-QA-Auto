package Steps;

import Util.LeerProperty;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Hooks {

  /*  @Before
    public static void  iniciar() throws Exception {

        String browser = LeerProperty.leerProperties().getProperty("navegador").toLowerCase();
        if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            FirefoxDriver driver=new FirefoxDriver();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
            driver.manage().window().maximize();

            driver.get(LeerProperty.leerProperties().getProperty("url"));
        }else if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeDriver driver=new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
            driver.manage().window().maximize();

            driver.get(LeerProperty.leerProperties().getProperty("url"));
        }else if (browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            EdgeDriver driver=new EdgeDriver();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
            driver.manage().window().maximize();

            driver.get(LeerProperty.leerProperties().getProperty("url"));
        }else{
            System.out.println("Navegador Incorrecto");
        }
    }*/

    private static WebDriver driver;

    @After
    public void TakeScreenShot(Scenario scenario){

        byte[] screenshotPass = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshotPass, "image/png", "Pass");

        if (scenario.isFailed()){
            byte[] screenshotFail = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotFail, "image/png", "Fail");
        }

/*        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();*/
    }

}
