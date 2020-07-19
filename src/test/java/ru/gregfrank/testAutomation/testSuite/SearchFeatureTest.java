package ru.gregfrank.testAutomation.testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.gregfrank.testAutomation.PageObjects.YourCartPage;

public class SearchFeatureTest extends BaseTest {

    YourCartPage yourCartPage;

    @Test
    public void checkSearchResults() {

        yourCartPage = new YourCartPage(webDriver);
        Assert.assertTrue(yourCartPage.searchForString("Wikipedia") > 0);

    }

}
