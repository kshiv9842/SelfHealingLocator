package org.Shiv.tests;

import java.io.IOException;

import org.Shiv.driver.DriverManager;
import org.Shiv.utils.PropertiesUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void setupDriver() throws IOException {
        DriverManager.setupDriver();
        DriverManager.navigateURL(PropertiesUtils.getPropertyValue("applicationUrl"));
    }
    @AfterMethod
    public void terminateDriver() {
        DriverManager.quitDriver();
    }
}
