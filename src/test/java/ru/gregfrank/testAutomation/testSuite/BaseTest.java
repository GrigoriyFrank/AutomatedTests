package ru.gregfrank.testAutomation.testSuite;

import org.testng.annotations.*;
import ru.gregfrank.testAutomation.Helpers;
import ru.gregfrank.testAutomation.SeleniumDriver;
import ru.gregfrank.testAutomation.TestListener;

import java.io.IOException;


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
