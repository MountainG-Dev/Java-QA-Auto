import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GoogleSearchTests {

    private WebDriver driver;

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "./src/test/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

    }

    @Test
    public void testGooglePage() {
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.clear();
        searchbox.sendKeys("Introducción a la automatización de pruebas");
        searchbox.submit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertEquals("Introducción a la automatización de pruebas - Buscar con Google", driver.getTitle());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
