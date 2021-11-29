package Common;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static Steps.Hooks.getDriver;

public class GenericFunctions{

    private static WebDriver driver;

    public GenericFunctions(){
        this.driver = getDriver();
    }

}
