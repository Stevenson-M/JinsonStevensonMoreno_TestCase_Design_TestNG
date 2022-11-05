package com.globant;

import org.testng.annotations.*;

import java.util.logging.Logger;

public class LoginTest {
    Logger logger = Logger.getLogger(this.getClass().getName());

    @BeforeClass
    public void account() {
        logger.info("--- Login Test ---");
        logger.info("Have a valid espn account");
    }

    @BeforeClass
    @Parameters({"browser"})
    public void openBrowser(String browser) {
        logger.info("Open: " + browser);
    }

    @BeforeMethod
    @Parameters({"URL"})
    public void searchPage(String url) {
        logger.info("Search the page: " + url);
    }

    @Test
    public void loginTest() {
        logger.info("Click in the top right button");
        logger.info("Click in the 'Log In' button");
        logger.info("Type the username");
        logger.info("Type the password" );
        logger.info("Click the 'Log In' button");
    }

    @AfterTest
    @Parameters({"browser"})
    public void closeBrowser(String browser) {
        logger.info("Close" + browser);
    }

}





