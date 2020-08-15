package ru.gregfrank.testAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.gregfrank.testAutomation.CustomLoadableComponent;

import static ru.gregfrank.testAutomation.SeleniumDriver.getDriver;
import static java.sql.DriverManager.getDriver;

/**
 *
 */

public abstract class BaseObjectPage<T extends CustomLoadableComponent<T>> extends CustomLoadableComponent<T> {
    private WebDriver driver;

    public BaseObjectPage(WebDriver driver) {
        this.driver = driver;
    }

    public T openPage(Class<T> clazz) {
        T page = PageFactory.initElements(getDriver(), clazz);
        return page.get();
    }

    public void openInitialPage(String url) {
        driver.get(url);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void type(By inputLocator, String text) {
        find(inputLocator).sendKeys(text);
    }

    public void type(WebElement input, String text) {
        input.sendKeys(text);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void click(WebElement element) {
        element.click();
    }

    public String getText(WebElement element) {return element.getText();}

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}