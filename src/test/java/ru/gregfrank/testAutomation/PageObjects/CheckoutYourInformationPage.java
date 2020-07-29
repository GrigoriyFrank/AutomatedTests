package ru.gregfrank.testAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import ru.gregfrank.testAutomation.Helpers;

public class CheckoutYourInformationPage extends LoadableComponent<CheckoutYourInformationPage> {

    WebDriver driver;

    public CheckoutYourInformationPage(WebDriver driver) {
        this.driver = driver;
        this.get();
    }

    public CheckoutOverviewPage addPersonalInfo(){
        driver.findElement(By.cssSelector("input[data-test=firstName]")).sendKeys("Bob");
        driver.findElement(By.cssSelector("input[data-test=lastName]")).sendKeys("Smith");
        driver.findElement(By.cssSelector("input[data-test=postalCode]")).sendKeys("1234567890");
        driver.findElement(By.cssSelector(".cart_button")).click();
        return new CheckoutOverviewPage(driver);
    }

    @Override
    protected void load() {

        Helpers.waitForElementVisibility(driver, By.cssSelector(".cart_button"));

    }

    @Override
    protected void isLoaded() throws Error {

        Assert.assertTrue(Helpers.isWebElementDisplayed(driver, By.cssSelector(".cart_button")), "Checkout: Your Information page is not yet loaded.");

    }
}
