package ru.gregfrank.testAutomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleSearchPage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchField;
    @FindBy(name = "btnK")
    private WebElement searchButton;
    @FindBy(className = "g")
    private List<WebElement> searchResults;

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public int searchForString(String searchString) {
        searchField.sendKeys(searchString);
        searchButton.click();
        return searchResults.size();

    }

}
