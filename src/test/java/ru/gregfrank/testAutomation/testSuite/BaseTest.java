package ru.gregfrank.testAutomation.testSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import ru.gregfrank.testAutomation.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    WebDriver webDriver;

    @Parameters({"browser", "url"})
    @BeforeMethod
    public void openBrowser(String browser, String url){

        if (browser.equalsIgnoreCase("chrome")) {
            webDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            webDriver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Check 'browser' argument! It must be either 'chrome' or 'firefox'");
        }

        webDriver.manage().window().maximize();
        webDriver.get(url);

    }

    @AfterMethod
    public void tearDown() {

        if (webDriver != null) {
            webDriver.quit();
        }

    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
