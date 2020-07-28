package ru.gregfrank.testAutomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class LoginPage extends LoadableComponent<LoginPage>{
    @FindBy(css = "input[data-test=username]")
    WebElement userName;
    @FindBy(css = "input[data-test=password]")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(css = "h3[data-test=error]")
    WebElement errorMessage;

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public ProductsPage loginValidUser(String userName, String password){

        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);

    }

    public LoginPage loginLockedUser(String userName, String password){

        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
        return this;

    }

    public String getErrorMessageText(){

        return  errorMessage.getText();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}
