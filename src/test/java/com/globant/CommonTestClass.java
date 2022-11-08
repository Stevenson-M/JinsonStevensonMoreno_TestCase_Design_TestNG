package com.globant;

import org.testng.annotations.*;

import java.util.logging.Logger;

public class CommonTestClass {
    Logger logger = Logger.getLogger(this.getClass().getName());


    @BeforeSuite
    public void checkAccountIsValid() {
        logger.info("Check the ESPN account is valid");

    }

    @BeforeMethod
    @Parameters({"browser"})
    public void openBrowser(String browser) {
        logger.info("Open: " + browser);
    }

    @BeforeMethod
    @Parameters({"URL"})
    public void searchPage(String url) {
        logger.info("Search the page: " + url);
    }

    @AfterTest
    @Parameters({"browser"})
    public void closeBrowser(String browser) {
        logger.info("Close " + browser);
    }


}
