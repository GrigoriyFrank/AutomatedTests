package ru.gregfrank.testAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import ru.gregfrank.testAutomation.Helpers;

public class YourCartPage extends BaseObjectPage<YourCartPage> {

    WebDriver driver;

    public YourCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.get();
    }

    public boolean checkNumberOfItemsInYourCartList(int number){

        return driver.findElements(By.cssSelector(".cart_item")).size() == number;
    }

    public YourCartPage removeProduct(int numberOfProduct){

        driver.findElement(By.cssSelector(String.format(".cart_item:nth-child(%d) .cart_button", numberOfProduct))).click();
        return this;
    }

    public CheckoutYourInformationPage checkout(){

        driver.findElement(By.cssSelector(".checkout_button")).click();
        return new CheckoutYourInformationPage(driver);
    }

    public String getNameOfProduct(int numberOfProduct){

        return driver.findElement(By.cssSelector(String.format(".cart_item:nth-child(%d) .inventory_item_name", numberOfProduct))).getText();
    }

    @Override
    protected void load() {

        Helpers.waitForElementVisibility(driver, By.cssSelector(".checkout_button"));

    }

    @Override
    protected void isLoaded() throws Error {

        Assert.assertTrue(Helpers.isWebElementDisplayed(driver, By.cssSelector(".checkout_button")), "Your Cart page is not yet loaded.");

    }
}
