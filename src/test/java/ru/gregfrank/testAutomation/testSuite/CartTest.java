package ru.gregfrank.testAutomation.testSuite;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.gregfrank.testAutomation.PageObjects.LoginPage;
import ru.gregfrank.testAutomation.PageObjects.ProductsPage;

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

//    When I added to cart 3 products from product list
//    Then I should see that status of selected products changed
//    And the number of selected products is on Product page

    @Test
    public void theNumberOfSelectedProductsMustBeVisibleOnProductsPage() {
        productsPage.addProductToCart(1);
        Assert.assertTrue(productsPage.isProductAddedToCart(1));
        Assert.assertTrue(productsPage.isNumberOfAddedProductsVisible(1));
    }

    @Parameters("numberOfProducts")
    @Test
    public void theSelectedProductsMustBeVisibleOnYourCartPage(@Optional("3") int numberOfProducts) {

        for (int i = 1; i <= numberOfProducts; i++) {
            productsPage.addProductToCart(i);

        }

        Assert.assertTrue(productsPage.openCart().checkNumberOfItemsInYourCartList(numberOfProducts));

    }
}
