package ru.gregfrank.testAutomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;

public class YourCartPage extends LoadableComponent<YourCartPage> {

    protected static WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchField;
    @FindBy(name = "btnK")
    private WebElement searchButton;
    @FindBy(className = "g")
    private List<WebElement> searchResults;

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int searchForString(String searchString) {
        searchField.sendKeys(searchString);
        searchButton.click();
        return searchResults.size();

    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}
