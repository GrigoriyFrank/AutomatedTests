package ru.gregfrank.testAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import ru.gregfrank.testAutomation.PageObjects.BaseObjectPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static ru.gregfrank.testAutomation.SeleniumDriver.getDriver;

/**
 * Custom Loadable Component
 */
public abstract class CustomLoadableComponent<T extends CustomLoadableComponent<T>> {
    private WebDriver driver;

    private static final int LOAD_TIMEOUT = 30;
    private static final long REFRESH_RATE = 1000;

    @SuppressWarnings("unchecked")
    public T get() {
        try {
            isLoaded();
            return (T) this;
        } catch (Error e) {
            // This is the extra line of code
            System.out.println("Error encountered during page load: " + e.getMessage());
            load();
        }

        isLoaded();

        return (T) this;
    }

    protected abstract void load();

    protected abstract void isLoaded() throws Error;

    protected void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
        Wait wait = new FluentWait(getDriver())
                .withTimeout(Duration.ofSeconds(LOAD_TIMEOUT))
                .pollingEvery(Duration.ofMillis(REFRESH_RATE));

        wait.until(pageLoadCondition);
    }

}
