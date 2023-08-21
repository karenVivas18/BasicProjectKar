package org.basic.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverManager {
    private static WebDriver driver;

    private static final Map<String, Supplier<WebDriver>> driverMap = new HashMap<>();

    static {
        driverMap.put("chrome", DriverManager::initializeChromeDriver);
        driverMap.put("firefox", DriverManager::initializeFirefoxDriver);
    }

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            driver = driverMap.getOrDefault(browser.toLowerCase(), () -> {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }).get();
        }
        return driver;
    }

    private static WebDriver initializeChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/karen.vivas/IdeaProjects/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }

    private static WebDriver initializeFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/karen.vivas/IdeaProjects/geckodriver.exe");
        return new FirefoxDriver();
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
      /*
    private static WebDriver initializeDriver(String browser) {
        if ("chrome".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.chrome.driver", "C:/Users/karen.vivas/IdeaProjects/chromedriver-win64/chromedriver-win64/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            return new ChromeDriver(options);
        } else if ("firefox".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.gecko.driver", "C:/Users/karen.vivas/IdeaProjects/geckodriver.exe");
            return new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
// mapa de streamy usar un suplier (clave chrome ....)
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }*/
}
