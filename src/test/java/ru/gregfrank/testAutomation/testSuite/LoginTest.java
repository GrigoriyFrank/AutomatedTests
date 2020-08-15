package ru.gregfrank.testAutomation.testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.gregfrank.testAutomation.PageObjects.LoginPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test(dataProvider = "getValidUserData", dataProviderClass = TestDataProvider.class)
    public void LoginToOnlineStoreWithValidUser(String userName, String password) {

        loginPage = new LoginPage();
        loginPage.loginValidUser(userName, password);

    }

    @Test(dataProvider = "getInvalidUserData", dataProviderClass = TestDataProvider.class)
    public void LoginToOnlineStoreWithLockedOrInvalidUser(String userName, String password, String errorMessage) {

        loginPage = new LoginPage();
        Assert.assertEquals(loginPage.loginLockedUser(userName, password).getErrorMessageText(), errorMessage);

    }

}
