package ru.gregfrank.testAutomation;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import ru.gregfrank.testAutomation.testSuite.BaseTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static ru.gregfrank.testAutomation.SeleniumDriver.getDriver;

public class TestListener  extends TestListenerAdapter {

    private static final String SCREENSHOT_DIR = System.getProperty("user.dir") + "\\testngOutput\\screenshots\\";
    @Override
    public void onTestFailure(ITestResult testResult) {
        super.onTestFailure(testResult);
        
        WebDriver webDriver = getDriver();
        if (webDriver != null) {
            File srcFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);

            String imageName = testResult.getName() + "-" + System.currentTimeMillis() + ".png";
            Reporter.log(" screenshot saved  <br></br> <a href = 'screenshots/" + imageName + "'><img src = 'screenshots/" + imageName + "' height='300px' max-width='auto'/> </a>");

            try {

                if(!Files.exists(Paths.get(SCREENSHOT_DIR))){

                    Files.createDirectory(Paths.get(SCREENSHOT_DIR));

                }
                Files.copy(Paths.get(srcFile.toURI()), Paths.get(SCREENSHOT_DIR + imageName), REPLACE_EXISTING);

            } catch (IOException e) {
                e.printStackTrace();
                Reporter.log("Error copying screenshot to the report! ERROR: " + e.getMessage());

            }
        }
    }
}
