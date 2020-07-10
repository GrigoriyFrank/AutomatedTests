package ru.gregfrank.testAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchPage extends BasePage {

    //search field
    private WebElement q;
    //search button
    private WebElement btnK;
    @FindBy(className = "g")
    private List<WebElement> searchResults;

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public int searchForString(String searchString) {
        q.sendKeys(searchString);
        btnK.click();
        return searchResults.size();

    }

}
