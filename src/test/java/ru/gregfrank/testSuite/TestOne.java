package ru.gregfrank.testSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestOne {

    public WebDriver webDriver;

    @AfterClass
    public void tearDown() {

        if (webDriver != null) {
            webDriver.quit();
        }

    }

    @Parameters("browser")
    @Test
    public void openBrowser(String browser){

        if (browser.equalsIgnoreCase("chrome")) {
            webDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            webDriver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Check 'browser' argument! It must be either 'chrome' or 'firefox'");
        }

        webDriver.manage().window().maximize();
        webDriver.get("https://www.google.com/");

    }

}
