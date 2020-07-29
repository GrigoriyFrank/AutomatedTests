package ru.gregfrank.testAutomation.testSuite;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

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

    @DataProvider(name = "getProductsData")
    public static Object[][] getProductsData() {
        return new Object[][]{
                {Arrays.asList(1,3,5), Arrays.asList("Sauce Labs Backpack","Sauce Labs Bolt T-Shirt","Sauce Labs Onesie")},
                {Arrays.asList(2,4,6), Arrays.asList("Sauce Labs Bike Light","Sauce Labs Fleece Jacket","Test.allTheThings() T-Shirt (Red)")},
                {Arrays.asList(1,4,5), Arrays.asList("Sauce Labs Backpack","Sauce Labs Fleece Jacket","Sauce Labs Onesie")},
        };
    }
}
