package org.Shiv.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    static WebDriver driver;

    public static void setupDriver() {
        driver = new ChromeDriver ();
        driver.manage ().window ().maximize ();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public static void quitDriver() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            setupDriver();
            return driver;
        } else
            return driver;
    }

    public static void navigateURL(String url) {
        driver.get(url);
    }
    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public static String getTitle(){
        return driver.getTitle();
    }
}

