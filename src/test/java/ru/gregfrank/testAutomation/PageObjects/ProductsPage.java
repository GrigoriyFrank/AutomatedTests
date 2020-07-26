package ru.gregfrank.testAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ProductsPage extends LoadableComponent<ProductsPage> {

    @FindBy(css = ".inventory_list")
    WebElement productList;
    @FindBy(css = ".inventory_item")
    List<WebElement> productItems;

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.get();
        PageFactory.initElements(driver, this);
    }

    public boolean productsPageIsOpened() {

        return productItems.size() > 0;
    }


    @Override
    protected void load() {

        System.out.println("load()");
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30).getSeconds());
        wait.until(visibilityOfElementLocated(By.cssSelector(".inventory_list")));
    }

    @Override
    protected void isLoaded() throws Error {

        System.out.println("isLoaded()");
        Assert.assertTrue(driver.findElement(By.cssSelector(".inventory_list")).isDisplayed(), "Product list is not yet loaded.");

    }
}
