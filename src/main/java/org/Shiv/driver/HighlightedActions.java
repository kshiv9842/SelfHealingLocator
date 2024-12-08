package org.Shiv.driver;

import static org.Shiv.driver.DriverManager.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HighlightedActions {

    // Highlight the element with green color
    public static void highlightElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].style.border='2px solid green'",
            element);
    }
    public static void highlightWebElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].style.border='2px solid green'",
            element);
    }
}