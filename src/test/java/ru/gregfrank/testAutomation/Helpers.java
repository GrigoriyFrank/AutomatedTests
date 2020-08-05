package ru.gregfrank.testAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Comparator;
import java.util.stream.Stream;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Helpers {

    private static final long WAIT = 5;

    public static void waitForElementVisibility(WebDriver driver, By locator) {

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT).getSeconds());
        wait.until(visibilityOfElementLocated(locator));
    }

    public static boolean isWebElementDisplayed(WebDriver driver, By locator) {

        return driver.findElement(locator).isDisplayed();

    }

    public static void deleteDir(String dir) throws IOException {

        Path path = Paths.get(dir);

        // read java doc, Files.walk need close the resources.
        // try-with-resources to ensure that the stream's open directories are closed
        try (Stream<Path> walk = Files.walk(path)) {
            walk
                    .sorted(Comparator.reverseOrder())
                    .forEach(Helpers::deleteDirectory);
        }

    }

    private static void deleteDirectory(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            System.err.printf("Unable to delete this path : %s%n%s", path, e);
        }
    }
}
