package ru.gregfrank.testAutomation.testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.gregfrank.testAutomation.PageObjects.LoginPage;

//TODO: extend loadableComponent
public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void LoginToOnlineStoreWithValidUser() {

        loginPage = new LoginPage(webDriver);
        loginPage.loginValidUser("standard_user", "secret_sauce");

    }

    @Test
    public void LoginToOnlineStoreWithLockedUser() {

        loginPage = new LoginPage(webDriver);
        Assert.assertEquals(loginPage.loginLockedUser("locked_out_user", "secret_sauce").getErrorMessageText(), "Epic sadface: Sorry, this user has been locked out.");

    }


    @Test
    public void LoginToOnlineStoreWithInvalidUser() {

        loginPage = new LoginPage(webDriver);
        Assert.assertEquals(loginPage.loginLockedUser("invalid_user", "secret_sauce").getErrorMessageText(), "Epic sadface: Username and password do not match any user in this service");

    }

}
