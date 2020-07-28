package ru.gregfrank.testAutomation.testSuite;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.gregfrank.testAutomation.PageObjects.LoginPage;
import ru.gregfrank.testAutomation.PageObjects.ProductsPage;
import ru.gregfrank.testAutomation.PageObjects.YourCartPage;

import java.util.Arrays;
import java.util.List;

public class CartTest extends BaseTest {

    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeMethod(dependsOnMethods = "openBrowser", alwaysRun = true)
    public void loginToSite() {

        loginPage = new LoginPage(webDriver);
        productsPage = loginPage.loginValidUser("standard_user", "secret_sauce");
        //TODO: maybe .productsPageIsOpened() is not needed as we have checks for load in Products page class
        Assert.assertTrue(productsPage.productsPageIsOpened());

    }

    @Parameters("numberOfProducts")
    @Test
    public void theNumberOfSelectedProductsMustBeVisibleOnProductsPage(@Optional("3") int numberOfProducts) {
        for (int i = 1; i <= numberOfProducts; i++) {
            productsPage.addProductToCart(i);
            Assert.assertTrue(productsPage.isProductAddedToCart(i));

        }

        Assert.assertTrue(productsPage.isNumberOfAddedProductsVisible(numberOfProducts));
    }

    @Parameters("numberOfProducts")
    @Test
    public void theSelectedProductsMustBeVisibleOnYourCartPage(@Optional("3") int numberOfProducts) {

        for (int i = 1; i <= numberOfProducts; i++) {
            productsPage.addProductToCart(i);

        }

        Assert.assertTrue(productsPage.openCart().checkNumberOfItemsInYourCartList(numberOfProducts));

    }

    @Test(dataProvider = "getProductsData")
    public void theOrderOfProductsOnYourCartPageMustBeTheSameAsTheyWereSelectedOnProductPage(List<Integer> numbersOfProduct, List<String> namesOfProduct){

        for(Integer number: numbersOfProduct){

            productsPage.addProductToCart(number);
        }

       YourCartPage yourCartPage = productsPage.openCart();

        for(Integer number: numbersOfProduct){

            Assert.assertEquals(yourCartPage.getNameOfProduct(numbersOfProduct.lastIndexOf(number) + 3), namesOfProduct.get(numbersOfProduct.lastIndexOf(number)), "The order of products is incorrect on Your Cart page");
        }

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
