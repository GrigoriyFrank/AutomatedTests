package ru.gregfrank.testAutomation.testSuite;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.gregfrank.testAutomation.PageObjects.MainPage;

public class SearchFeatureTest extends BaseTest {

    MainPage mainPage;

    @Test
    public void checkSearchResults() {

        mainPage = PageFactory.initElements(webDriver, MainPage.class);
        Assert.assertTrue(mainPage.searchForString("Wikipedia") > 0);

    }

}
