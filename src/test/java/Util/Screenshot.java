/*package Util;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.google.common.io.Files;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {
    private String destDir;
    private DateFormat dateFormat;
    private WebDriver driver;

    public Screenshot(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenShot() {

        String separador = System.getProperty("file.separator");
        destDir = System.getProperty("user.dir") + separador + "reportes" + separador + "img" + separador;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        String destFile = dateFormat.format(new Date()) + ".png";
        File destinationFile = new File(destDir + destFile);
        try {
            Files.move(scrFile, destinationFile);
            ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(destDir + destinationFile.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void TakeScreenshot(String scenario){

        try {
            String separador = System.getProperty("file.separator");
            byte[] screenshotonPass = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            File screenshotonPass = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String folderPath = System.getProperty("user.dir") + separador + "test-output/Screenshot" + separador;
            SimpleDateFormat nowHours = new SimpleDateFormat("dd-MMM-yyyy_hh_mm_ssaa");
            String fechaHora = nowHours.format(new Date());
            File destinationPath = new File(folderPath + fechaHora + "_" + scenario + ".png");
            Files.move(screenshotonPass, destinationPath);
            ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(destinationPath.getName());

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void TakeScreenshot(Scenario scenario){
        byte[] screenshotonPass = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshotonPass, "image/png", "Pass");

        if (scenario.isFailed()){
            byte[] screenshotFail = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotonPass, "image/png", "Failed");
        }
    }

}*/
