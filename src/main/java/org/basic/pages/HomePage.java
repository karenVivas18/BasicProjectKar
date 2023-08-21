package org.basic.pages;

import org.basic.driver.WaitUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    private WebDriver driver;
    private WaitUtils waitUtils;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUtils = new WaitUtils(driver);
    }

    //@FindBy(xpath="//*[@id='multi-product-search-form-1']/div/div/div[1]/ul/li[2]")
    @FindBy(css = "a.uitk-tab-anchor[href='Flights']")
    private WebElement flights;
    @FindBy(css = "[data-stid='origin_select-menu-trigger']")
    private WebElement originField;
    @FindBy(css = "[data-stid='origin_select-menu-input']")
    private WebElement originBox;
    @FindBy(css = "[data-stid='destination_select-menu-trigger']")
    private WebElement destinationField;
    @FindBy(css = "[data-stid='destination_select-menu-input']")
    private WebElement destinationBox;
    @FindBy(css = "#date_form_field-btn")
    private WebElement dateField;
    @FindBy(css = ".uitk-date-picker-weeks .uitk-date-picker-day-number.uitk-date-picker-first-of-month")
    private WebElement firstDate;
    @FindBy(css = "#FlightSearchForm_ROUND_TRIP .uitk-calendar button:nth-child(2)")
    private WebElement nextMonthBtn;
    @FindBy(css = "[data-stid='open-room-picker']")
    private WebElement travelersBtn;
    @FindBy(css = "#traveler_selector_adult_step_input-0")
    private WebElement adultTravelers;
    @FindBy(css = "[data-stid='travelers_selector_done_button']")
    private WebElement doneTravelersBtn;
    @FindBy(css = "[data-stid='apply-date-picker']")
    private WebElement doneDateBtn;
    @FindBy(css = "#search_button")
    private WebElement searchBtn;
    @FindBy(css = "button [aria-label='Decrease the number of adults in room 1']")
    private WebElement decreaseAdultBtn;
    @FindBy(css = "button [aria-label='Increase the number of adults in room 1']")
    private WebElement increaseAdultBtn;
    @FindBy(css = "[data-stid='typeahead-originInput-0-menu-trigger']")
    private WebElement flyingFromResult;
    @FindBy(css = "[data-stid='typeahead-destinationInput-0-menu-trigger']")
    private WebElement flyingToResult;
    @FindBy(css = "#sort-filter-dropdown-SORT")
    private WebElement sortDropDown;
    @FindBy(css = "[data-test-id='price-column']")
    private WebElement priceColumn;
    @FindBy(css = "[data-test-id='select-button']")
    private WebElement selectButton;
    @FindBy(css = "[data-test-id='intersection-observer']")
    private WebElement intersection;

    public void clickSelectBtn(){
        selectButton.click();
    }
    public void goFlightsSearch() {
        flights.click();
    }
    public void selectOrigin(String origin) {
        originField.click();
        originBox.sendKeys(origin);
        originBox.sendKeys(Keys.ENTER);
    }
    public void selectDest(String destination) {
        destinationField.click();
        destinationBox.sendKeys(destination);
        destinationBox.sendKeys(Keys.ENTER);
    }

}
