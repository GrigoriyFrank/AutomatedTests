package ru.gregfrank.testAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends BasePage {

    protected static WebDriver driver;

    //search field
    private WebElement q;
    //search button
    private WebElement btnK;
    @FindBy(className = "g")
    private List<WebElement> searchResults;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public int searchForString(String searchString) {
        q.sendKeys(searchString);
        btnK.click();
        return searchResults.size();

    }

}
