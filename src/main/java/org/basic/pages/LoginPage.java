package org.basic.pages;

import org.basic.driver.WaitUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    private WaitUtils waitUtils;

    @FindBy(css = "#loginFormEmailInput")
    private WebElement emailField;

    @FindBy(css = "#loginFormPasswordInput")
    private WebElement passwordField;

    @FindBy(css = "#loginFormSubmitButton")
    private WebElement loginButton;

    /**
     * Constructor.
     *
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);  // Llamada al constructor de la clase base
        PageFactory.initElements(driver, this);
        waitUtils = new WaitUtils(driver);
    }
    @FindBy(css = "#gc-custom-header-nav-bar-acct-menu")
    private WebElement signBtn1;
    @FindBy(css = "[data-stid='link-header-account-signin']")
    private WebElement signInOption;
    @FindBy(css = "a[href*='/user/logout']")
    private WebElement signOutBtn;

    public boolean isUserLogged() {
        waitUtils.waitForElementToBeClickable(signBtn1);
        signBtn1.click();
        try {
            return signInOption.isDisplayed();
        } catch (NoSuchElementException e) {
            return true;
        }
    }
    public LoginPage logOut() {
        signBtn1.click();
        signOutBtn.click();
        return this;
    }
    public LoginPage clickSingIn() {
        signBtn1.click();
        signInOption.click();
        return this;
    }
}
