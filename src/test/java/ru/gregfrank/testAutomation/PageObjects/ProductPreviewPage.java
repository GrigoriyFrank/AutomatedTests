package ru.gregfrank.testAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import ru.gregfrank.testAutomation.Helpers;
import ru.gregfrank.testAutomation.PageLoadHelper;

//import static ru.gregfrank.testAutomation.SeleniumDriver.getDriver;

public class ProductPreviewPage extends BaseObjectPage<ProductPreviewPage> {

    @FindBy(css = ".btn_primary")
    WebElement addToCart;
    @FindBy(css = ".shopping_cart_link")
    WebElement shoppingCart;

    public ProductPreviewPage() {
        super();
    }

    public ProductPreviewPage addProductToCart() {

        click(addToCart);
        return this;
    }

    public YourCartPage openCart() {
        click(shoppingCart);
        return new YourCartPage().openPage(YourCartPage.class);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

        PageLoadHelper.isLoaded()
                .isElementIsVisible(By.cssSelector(".inventory_details_back_button"))
                .isElementIsClickable(By.cssSelector(".inventory_details_back_button"));

    }
}
