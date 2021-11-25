package Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {

    public static void main(String[] args) {

        //Chrome Browser
        //System.setProperty("webdriver.chrome.driver", "./src/test/resources/Drivers/chromedriver.exe");
        //WebDriver driver=new ChromeDriver();    //ChromeDriver driver=new ChromeDriver();

        //Firefox Browser
        //System.setProperty("webdriver.gecko.driver", "./src/test/resources/Drivers/geckodriver.exe");
        //WebDriver driver=new FirefoxDriver();  //FirefoxDriver driver=new FirefoxDriver();


        //Edge Browser
        //System.setProperty("webdriver.edge.driver", "./src/test/resources/Drivers/msedgedriver.exe");
        //WebDriver driver2=new EdgeDriver();     //EdgeDriver driver=new EdgeDriver();


        //**** Using WebDriverManager ****//

        //Chrome Browser
        //WebDriverManager.chromedriver().setup();
        //ChromeDriver driver=new ChromeDriver();

        //Firefox Browser
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver=new FirefoxDriver();

        //Edge Browser
        //WebDriverManager.edgedriver().setup();
        //EdgeDriver driver=new EdgeDriver();

        driver.get("https://www.demoblaze.com");
    }

}
