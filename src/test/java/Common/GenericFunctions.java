package Common;

import org.openqa.selenium.WebDriver;
import static Steps.Hooks.*;

public class GenericFunctions {
    private WebDriver driver;
    public GenericFunctions(){
        this.driver = getDriver();
    }

}
