package ru.gregfrank.testAutomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class LoginPage extends LoadableComponent<LoginPage> {
    @FindBy(css = "input[data-test=username]")
    WebElement userName;
    @FindBy(css = "input[data-test=password]")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement loginButton;

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.get();
        PageFactory.initElements(driver, this);
    }


    public ProductsPage loginUser(String userName, String password){

        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);

    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}
