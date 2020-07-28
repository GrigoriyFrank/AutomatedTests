package ru.gregfrank.testAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Helpers {

    private static final long WAIT = 5;

    public static void waitForElementVisibility(WebDriver driver, By locator){

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT).getSeconds());
        wait.until(visibilityOfElementLocated(locator));
    }

    public static boolean isWebElementDisplayed(WebDriver driver, By locator){

        return driver.findElement(locator).isDisplayed();

    }
}
