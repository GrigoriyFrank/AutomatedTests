package ru.gregfrank.testAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import ru.gregfrank.testAutomation.Helpers;

public class ProductPreviewPage extends LoadableComponent<ProductPreviewPage> {

    WebDriver driver;

    public ProductPreviewPage(WebDriver driver) {
        this.driver = driver;
        this.get();
    }

    public ProductPreviewPage addProductToCart() {

        driver.findElement(By.cssSelector(".btn_primary")).click();
        return this;
    }

    //TODO: duplication. Need somehow avoid it. Maybe to use loadable components for header, footer etc.?
    public YourCartPage openCart() {
        driver.findElement((By.cssSelector(".shopping_cart_link"))).click();
        return new YourCartPage(driver);
    }

    @Override
    protected void load() {

        Helpers.waitForElementVisibility(driver, By.cssSelector(".btn_primary"));
    }

    @Override
    protected void isLoaded() throws Error {

        Assert.assertTrue(Helpers.isWebElementDisplayed(driver, By.cssSelector(".btn_primary")), "Product Preview page is not yet loaded.");

    }
}
