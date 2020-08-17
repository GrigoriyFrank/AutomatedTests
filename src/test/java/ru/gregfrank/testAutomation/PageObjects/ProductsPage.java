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

import java.util.List;

import static ru.gregfrank.testAutomation.SeleniumDriver.getDriver;

public class ProductsPage extends BaseObjectPage<ProductsPage> {

    static final String ADD_TO_CART_selector = ".inventory_item:nth-child(%d) .btn_primary";
    static final String REMOVE_selector = ".inventory_item:nth-child(%d) .btn_secondary";

    @FindBy(css = ".inventory_list")
    WebElement productList;
    @FindBy(css = ".inventory_item")
    List<WebElement> productItems;
    @FindBy(css = ".shopping_cart_link")
    WebElement shoppingCart;
    @FindBy(css = ".shopping_cart_badge")
    WebElement shoppingCartBadge;
    @FindBy(id = "item_4_title_link")
    WebElement firstProduct;


    WebDriver driver;

    public ProductsPage() {
        super(getDriver());
    }

    public boolean productsPageIsOpened() {

        return productItems.size() > 0;
    }

    public ProductsPage addProductToCart(int numberOfProduct) {

        click(By.cssSelector(String.format(ADD_TO_CART_selector, numberOfProduct)));
        return this;
    }

    public ProductsPage removeProductFromCart(int numberOfProduct) {

        click(By.cssSelector(String.format(REMOVE_selector, numberOfProduct)));
        return this;
    }

    public boolean isProductAddedToCart(int numberOfProduct) {

        return isElementDisplayed(By.cssSelector(String.format(REMOVE_selector, numberOfProduct)));
    }

    public boolean isNumberOfAddedProductsVisible(int count) {

        return getText(shoppingCartBadge).equals(Integer.toString(count));

    }

    public YourCartPage openCart() {
        click(shoppingCart);
        return new YourCartPage().openPage(YourCartPage.class);
    }

    public ProductPreviewPage openFirstProductPreview() {
        click(firstProduct);
        return new ProductPreviewPage().openPage(ProductPreviewPage.class);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

        PageLoadHelper.isLoaded()
                .isElementIsVisible(By.cssSelector(".inventory_list"));

    }
}
