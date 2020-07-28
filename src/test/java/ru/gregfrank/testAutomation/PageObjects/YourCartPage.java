package ru.gregfrank.testAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.gregfrank.testAutomation.Helpers;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class YourCartPage extends LoadableComponent<YourCartPage> {

    WebDriver driver;

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
        this.get();
    }

    public boolean checkNumberOfItemsInYourCartList(int number){

        return driver.findElements(By.cssSelector(".cart_item")).size() == number;
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
