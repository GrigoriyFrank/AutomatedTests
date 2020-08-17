package ru.gregfrank.testAutomation.testSuite;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import ru.gregfrank.testAutomation.Helpers;
import ru.gregfrank.testAutomation.SeleniumDriver;
import ru.gregfrank.testAutomation.TestListener;
import ru.gregfrank.testAutomation.WebDriverLogger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//import static ru.gregfrank.testAutomation.SeleniumDriver.getDriver;

@Listeners(TestListener.class)
public class BaseTest {

    private static final String SCREENSHOT_DIR = System.getProperty("user.dir") + "\\testngOutput\\screenshots\\";

    @BeforeSuite
    public void deleteScreenshots() {
        try {
            Helpers.deleteDir(SCREENSHOT_DIR);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Parameters("browser")
    @BeforeMethod
    public void setBrowser(String browser) {
        SeleniumDriver.setBrowser(browser);

    }

    @AfterMethod
    public void tearDown() {

        SeleniumDriver.get().quitDriver(SeleniumDriver.get().getDriver());

    }

}
