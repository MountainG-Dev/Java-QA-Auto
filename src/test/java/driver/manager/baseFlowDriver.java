package driver.manager;

import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static util.leerProperty.leerProperties;

@RunWith(Suite.class)
public class baseFlowDriver {

    public static RemoteWebDriver driver;
   // public static SqlSessionFactory sqlSessionFactory = null;
  //  public static BrowserMobProxyServer browserMobProxy;

    @BeforeClass
    public static void setUp() throws Exception {
        String navegador = leerProperties().getProperty("navegador").toLowerCase();
        String sistemaOperativo = leerProperties().getProperty("sistemaOperativo").toLowerCase();
        String execution = leerProperties().getProperty("execution").toLowerCase();

     // mybatisConfig();
        switch (execution) {
            case "local":
                setDriverSeleniumWD(navegador,sistemaOperativo,execution);
                break;
            case "hub":
//        	setDriverSeleniumGrid(navegador,sistemaOperativo,execution);
                break;
        }
    }

    public static void setDriverSeleniumWD(String navegador, String sistemaOperativo, String execution) throws Exception {
        switch (navegador) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chrome/windows/chromedriver.exe");
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.notifications", 2);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
               // DesiredCapabilities capabilities = DesiredCapabilities.chrome();
               // capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                break;

            case "firefox":

                break;
        }
    }


   // public static void mybatisConfig() throws Exception{
   //     String resouce = "mybatis/config/mybatis-config.xml";
   //     InputStream inputStream = Resources.getResourceAsStream(resouce);
   //     sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
   //     System.out.println("**** Conexion Exitosa ****");
   // }





}
