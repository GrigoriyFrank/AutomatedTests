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

    @Test(dataProvider = "getProductsData", dataProviderClass = TestDataProvider.class)
    public void theOrderOfProductsOnYourCartPageMustBeTheSameAsTheyWereSelectedOnProductPage(List<Integer> numbersOfProduct, List<String> namesOfProduct) {

        for (Integer number : numbersOfProduct) {

            productsPage.addProductToCart(number);
        }

        for (Integer number : numbersOfProduct) {

            Assert.assertEquals(productsPage.openCart().getNameOfProduct(numbersOfProduct.lastIndexOf(number) + 3), namesOfProduct.get(numbersOfProduct.lastIndexOf(number)), "The order of products is incorrect on Your Cart page");
        }

    }

    @Test(dataProvider = "getProductsDataToCheckRemove", dataProviderClass = TestDataProvider.class)
    public void removeProductFromCartOnProductPage(List<Integer> numbersOfProduct, List<String> namesOfProduct) {

        int indexOfProductToRemove = 1;
        for (Integer number : numbersOfProduct) {

            productsPage.addProductToCart(number);
        }

        productsPage.removeProductFromCart(numbersOfProduct.get(indexOfProductToRemove));

        for (String name : namesOfProduct) {
            Assert.assertEquals(productsPage.openCart().getNameOfProduct(namesOfProduct.lastIndexOf(name) + 3), name, "Removed product is on Your Cart page");
        }


    }

    @Test(dataProvider = "getProductsDataToCheckRemove", dataProviderClass = TestDataProvider.class)
    public void removeProductFromCartOnYourCartPage(List<Integer> numbersOfProduct, List<String> namesOfProduct) {

        int indexOfProductToRemove = 1;
        for (Integer number : numbersOfProduct) {

            productsPage.addProductToCart(number);
        }

        Assert.assertTrue(
                productsPage
                        .openCart()
                        .removeProduct(indexOfProductToRemove + 3)
                        .checkout()
                        .addPersonalInfo()
                        .checkNumberOfProductsInOrder(namesOfProduct.size()),
                "The number of products is wrong");

    }

}
