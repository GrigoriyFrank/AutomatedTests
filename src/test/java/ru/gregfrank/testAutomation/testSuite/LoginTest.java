package ru.gregfrank.testAutomation.testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.gregfrank.testAutomation.PageObjects.LoginPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void LoginToOnlineStoreWithValidUser() {

        loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.loginValidUser("standard_user", "secret_sauce").productsPageIsOpened());

    }

    @Test
    public void LoginToOnlineStoreWithLockedUser() {

        loginPage = new LoginPage(webDriver);
        Assert.assertEquals(loginPage.loginLockedUser("locked_out_user", "secret_sauce").getErrorMessageText(), "Epic sadface: Sorry, this user has been locked out.");

    }

}
