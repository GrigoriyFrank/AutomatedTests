package ru.gregfrank.testAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import ru.gregfrank.testAutomation.Helpers;

public class CheckoutOverviewPage extends LoadableComponent<CheckoutOverviewPage> {

    WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        this.get();
    }


    public boolean checkNumberOfProductsInOrder(int expectNumber){

        return driver.findElements(By.cssSelector(".cart_item")).size() == expectNumber;
    }

    @Override
    protected void load() {

        Helpers.waitForElementVisibility(driver, By.cssSelector(".cart_button"));

    }

    @Override
    protected void isLoaded() throws Error {

        Assert.assertTrue(Helpers.isWebElementDisplayed(driver, By.cssSelector(".cart_button")), "Checkout: Overview page is not yet loaded.");

    }
}
