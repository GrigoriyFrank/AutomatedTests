package ru.gregfrank.testAutomation.testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.gregfrank.testAutomation.PageObjects.LoginPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void LoginToOnlineStoreWithValidUser() {

        loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.loginUser("standard_user", "secret_sauce").productsPageIsOpened());

    }

}
