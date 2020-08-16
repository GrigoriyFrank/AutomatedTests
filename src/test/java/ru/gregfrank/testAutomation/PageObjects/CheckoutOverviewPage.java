package ru.gregfrank.testAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import ru.gregfrank.testAutomation.Helpers;
import ru.gregfrank.testAutomation.PageLoadHelper;

import java.util.List;

import static ru.gregfrank.testAutomation.SeleniumDriver.getDriver;

public class CheckoutOverviewPage extends BaseObjectPage<CheckoutOverviewPage> {

    @FindBy(css = ".cart_item")
    List<WebElement> products;

    public CheckoutOverviewPage() {
      super(getDriver());
    }


    public boolean checkNumberOfProductsInOrder(int expectNumber){

        return products.size() == expectNumber;
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

        PageLoadHelper.isLoaded()
                .isElementIsVisible(By.cssSelector(".cart_button"))
                .isElementIsClickable(By.cssSelector(".cart_button"));

    }
}
