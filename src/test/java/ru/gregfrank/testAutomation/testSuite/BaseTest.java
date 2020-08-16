package ru.gregfrank.testAutomation.testSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import ru.gregfrank.testAutomation.Helpers;
import ru.gregfrank.testAutomation.TestListener;
import ru.gregfrank.testAutomation.WebDriverLogger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Listeners(TestListener.class)
public class BaseTest {

    private static final String SCREENSHOT_DIR = System.getProperty("user.dir") + "\\testngOutput\\screenshots\\";
    //    WebDriver webDriver;
    EventFiringWebDriver webDriver;

    @BeforeSuite
    public void deleteScreenshots() {
        try {
            Helpers.deleteDir(SCREENSHOT_DIR);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {

        if (webDriver != null) {
            webDriver.quit();
        }

    }

}
