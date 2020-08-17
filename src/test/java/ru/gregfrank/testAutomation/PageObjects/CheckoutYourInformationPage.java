package ru.gregfrank.testAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import ru.gregfrank.testAutomation.Helpers;
import ru.gregfrank.testAutomation.PageLoadHelper;

//import static ru.gregfrank.testAutomation.SeleniumDriver.getDriver;

public class CheckoutYourInformationPage extends BaseObjectPage<CheckoutYourInformationPage> {

    @FindBy(css = "input[data-test=firstName]")
    WebElement firstName;
    @FindBy(css = "input[data-test=lastName]")
    WebElement lastName;
    @FindBy(css = "input[data-test=postalCode]")
    WebElement postalCode;
    @FindBy(css = ".cart_button")
    WebElement continueButton;

    public CheckoutYourInformationPage() {
       super();
    }

    public CheckoutOverviewPage addPersonalInfo(){
        type(firstName, "Bob");
        type(lastName, "Smith");
        type(postalCode, "1234567890");
        click(continueButton);
        return new CheckoutOverviewPage().openPage(CheckoutOverviewPage.class);
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
