package ru.gregfrank.testAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Selenium driver wrapper
 *
 *
 */
public class SeleniumDriver {

	public static SeleniumDriver get() {
		return new SeleniumDriver();
	}

	public WebDriver driver;
	private static String BROWSER = "chrome";
	private static final String REMOTE = System.getProperty("selenium.remote", "true");
	private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

	public WebDriver getDriver() {
		if (driverThread.get() == null) {
			switch (BROWSER) {
				case "chrome":
					if (Boolean.parseBoolean(REMOTE)) {
						DesiredCapabilities capabilities = DesiredCapabilities.chrome();
						capabilities.setCapability("enableVNC", true);
						capabilities.setCapability("enableLog", true);
						capabilities.setCapability("enableVideo", true);
						driver = initRemoteDriver(capabilities);
					} else {
						driver = new ChromeDriver();
					}
					driverThread.set(driver);
					break;

				case "firefox":
					if (Boolean.parseBoolean(REMOTE)) {
						driver = initRemoteDriver(DesiredCapabilities.firefox());
					} else {
						driver = new FirefoxDriver();
					}
					driverThread.set(driver);
					break;
			}
		}
		return driverThread.get();
	}

	public RemoteWebDriver initRemoteDriver(DesiredCapabilities capabilities) {
		RemoteWebDriver remoteDriver = null;
		try {
			remoteDriver = new RemoteWebDriver(new URL("http://localhost:8080/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return remoteDriver;
	}

	public void quitDriver(WebDriver driver) {
		driver.quit();
		driverThread.remove();
	}

	public static void setBrowser(String browser) {
		SeleniumDriver.BROWSER = browser;
	}

}
