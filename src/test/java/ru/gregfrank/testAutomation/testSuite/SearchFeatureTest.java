package ru.gregfrank.testAutomation.testSuite;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.gregfrank.testAutomation.PageObjects.MainScreen;

public class SearchFeatureTest extends BaseTest {

    MainScreen mainScreen;

    @Test
    public void checkSearchResults() {

        mainScreen = PageFactory.initElements(webDriver, MainScreen.class);
        Assert.assertTrue(mainScreen.searchForString("Wikipedia") > 0);

    }

}
