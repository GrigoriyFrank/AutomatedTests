package ru.gregfrank.testAutomation.testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.gregfrank.testAutomation.PageObjects.LoginPage;

public class LoginTest extends BaseTest {


    @Test(dataProvider = "getValidUserData", dataProviderClass = TestDataProvider.class)
    public void LoginToOnlineStoreWithValidUser(String userName, String password) {

        LoginPage loginPage = new LoginPage().openPage(LoginPage.class);
        loginPage.loginValidUser(userName, password);

    }

    @Test(dataProvider = "getInvalidUserData", dataProviderClass = TestDataProvider.class)
    public void LoginToOnlineStoreWithLockedOrInvalidUser(String userName, String password, String errorMessage) {

        LoginPage loginPage = new LoginPage().openPage(LoginPage.class);
        Assert.assertEquals(
                loginPage
                        .loginLockedUser(userName, password)
                        .getErrorMessageText()
                , errorMessage);

    }

}
