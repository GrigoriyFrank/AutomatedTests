package ru.gregfrank.testAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.gregfrank.testAutomation.PageLoadHelper;

import java.util.List;


public class YourCartPage extends BaseObjectPage<YourCartPage> {

    static final String PRODUCT_NAME_selector = ".cart_item:nth-child(%d) .inventory_item_name";
    static final String REMOVE_selector = ".cart_item:nth-child(%d) .cart_button";

    @FindBy(css = ".cart_item")
    List<WebElement> products;
    @FindBy(css = ".checkout_button")
    WebElement checkoutButton;

    public YourCartPage() {
        super();
    }

    public boolean checkNumberOfItemsInYourCartList(int number) {

        return products.size() == number;
    }

    public YourCartPage removeProduct(int numberOfProduct) {

        click(By.cssSelector(String.format(REMOVE_selector, numberOfProduct)));
        return this;
    }

    public CheckoutYourInformationPage checkout() {

        click(checkoutButton);
        return new CheckoutYourInformationPage().openPage(CheckoutYourInformationPage.class);
    }

    public String getNameOfProduct(int numberOfProduct) {

        return getText(By.cssSelector(String.format(PRODUCT_NAME_selector, numberOfProduct)));
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

        PageLoadHelper.isLoaded()
                .isElementIsVisible(By.cssSelector(".checkout_button"))
                .isElementIsClickable(By.cssSelector(".checkout_button"));

    }
}
