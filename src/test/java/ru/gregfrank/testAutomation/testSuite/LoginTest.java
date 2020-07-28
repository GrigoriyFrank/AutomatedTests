package ru.gregfrank.testAutomation.testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.gregfrank.testAutomation.PageObjects.LoginPage;

import java.util.Arrays;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test(dataProvider = "getValidUserData", dataProviderClass = TestDataProvider.class)
    public void LoginToOnlineStoreWithValidUser(String userName, String password) {

        loginPage = new LoginPage(webDriver);
        loginPage.loginValidUser(userName, password);

    }

    @Test(dataProvider = "getInvalidUserData", dataProviderClass = TestDataProvider.class)
    public void LoginToOnlineStoreWithLockedOrInvalidUser(String userName, String password, String errorMessage) {

        loginPage = new LoginPage(webDriver);
        Assert.assertEquals(loginPage.loginLockedUser(userName, password).getErrorMessageText(), errorMessage);

    }

}
