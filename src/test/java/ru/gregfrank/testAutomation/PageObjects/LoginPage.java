package ru.gregfrank.testAutomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


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

    public LoginPage() {
        super();
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

    }

    @Override
    protected void isLoaded() throws Error {
        openInitialPage(BASE_URL);
//        PageLoadHelper.isLoaded()
//                .isElementIsVisible(By.id("login-button"))
//                .isElementIsClickable(By.id("login-button"));
    }
}
