package ru.gregfrank.testAutomation.testSuite;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "getValidUserData")
    public static Object[][] getValidUserData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}
        };
    }

    @DataProvider(name = "getInvalidUserData")
    public static Object[][] getInvalidUserData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"invalid_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"}
        };
    }
}
