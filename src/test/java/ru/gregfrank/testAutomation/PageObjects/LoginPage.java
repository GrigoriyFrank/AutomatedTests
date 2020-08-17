package ru.gregfrank.testAutomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static ru.gregfrank.testAutomation.SeleniumDriver.getDriver;

public class LoginPage extends BaseObjectPage<LoginPage>{
    private static final String BASE_URL = "https://www.saucedemo.com";
    @FindBy(css = "input[data-test=username]")
    WebElement userName;
    @FindBy(css = "input[data-test=password]")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(css = "h3[data-test=error]")
    WebElement errorMessage;

    WebDriver driver;

    public LoginPage() {
        super(getDriver());
        getDriver().manage().window().maximize();
        this.openPage(LoginPage.class);
    }


    public ProductsPage loginValidUser(String userName, String password) {

        type(this.userName, userName);
        type(this.password, password);
        click(loginButton);
        return new ProductsPage().openPage(ProductsPage.class);

    }

    public LoginPage loginLockedUser(String userName, String password) {

        type(this.userName, userName);
        type(this.password, password);
        click(loginButton);
        return this;

    }

    public String getErrorMessageText() {

        return getText(errorMessage);
    }

    @Override
    protected void load() {
        openInitialPage(BASE_URL);
    }

    @Override
    protected void isLoaded() throws Error {
        //TODO: Assertion is not reached if element is not find on the page. So it is not clear (no error) that page is not loaded
//        Assert.assertTrue(Helpers.isWebElementDisplayed(driver, By.id("login-button")), "Login page is not yet loaded.");
    }
}
