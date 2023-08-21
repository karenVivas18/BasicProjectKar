package org.basic;

import org.basic.driver.DriverManager;
import org.basic.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected Properties config;



    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void beforeTest(String browser, String url) {
        loadConfigProperties();
        driver = DriverManager.getDriver(browser);
        homePage = new HomePage(driver);
        homePage.navigateTo(url);
    }

    @AfterSuite(alwaysRun = true)
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
// aftersuit
    protected void loadConfigProperties() {
        config = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            config.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Properties getConfig() {
        return config;
    }
}
