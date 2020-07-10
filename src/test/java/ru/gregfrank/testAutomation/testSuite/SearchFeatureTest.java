package ru.gregfrank.testAutomation.testSuite;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.gregfrank.testAutomation.PageObjects.GoogleSearchPage;

public class SearchFeatureTest extends BaseTest {

    GoogleSearchPage googleSearchPage;

    @Test
    public void checkSearchResults() {

        googleSearchPage = new GoogleSearchPage(webDriver);
        Assert.assertTrue(googleSearchPage.searchForString("Wikipedia") > 0);

    }

}
