package ru.gregfrank.testAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.gregfrank.testAutomation.SeleniumDriver.getDriver;

public class PageLoadHelper {

    private static final int TIMEOUT = 10;

    public static PageLoadHelper isLoaded() {
        return new PageLoadHelper();
    }


    public PageLoadHelper isElementIsClickable(By by) {
        try {
            new WebDriverWait(getDriver(), TIMEOUT).until(ExpectedConditions.elementToBeClickable(by));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element is not clickable");
        }
    }

    public PageLoadHelper isElementIsVisible(By by) {
        try {
            new WebDriverWait(getDriver(), TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(by));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element is not visible");
        }
    }

}
