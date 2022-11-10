package org.globant.tests;

import static java.lang.String.format;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.globant.configuration.Driver;
import org.globant.pages.MainPage;
import org.globant.reporting.Reporter;
import org.testng.annotations.Parameters;


public class BaseTest {

    public Driver driver;
    protected MainPage mainPage;

    @Parameters({"browser", "url"})
    @BeforeTest()
    public void testSetup(String browser, String url) {
        driver = new Driver(browser);
        Reporter.info("Deleting all cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info(format("Navigating to %s", url));
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
        mainPage = new MainPage(driver.getDriver());
    }

    @AfterTest
    public void tearDown() {
        Reporter.info("Closing browser");
        driver.getDriver().quit();
    }


}
