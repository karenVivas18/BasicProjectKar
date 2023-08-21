package org.basic.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public void navigateTo(String url) {
        driver.get(url);
    }
}
