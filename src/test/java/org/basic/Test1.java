package org.basic;

import org.basic.driver.DriverManager;
import org.basic.pages.*;

import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.basic.driver.DriverManager.*;

public class Test1 extends BaseTest{

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeSuite(alwaysRun = true)
    public void setUpTest() {
        super.loadConfigProperties();
        driver = DriverManager.getDriver(config.getProperty("browser"));
        loginPage = new LoginPage(driver); // Inicializa loginPage
        homePage = new HomePage(driver);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
    @Test
    public void testNew() {
        if (loginPage.isUserLogged()) {
            loginPage.logOut();
        }
        homePage.goFlightsSearch();
    }
}
