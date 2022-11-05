package com.globant;

import org.testng.annotations.*;

import java.util.logging.Logger;

public class DeactivateUserTest {
    Logger logger = Logger.getLogger(this.getClass().getName());

    @BeforeClass
    public void account() {
        logger.info("--- Deactivate User Test ---");
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
    public void deactivateUserTest() {
        logger.info("Click in the top right button");
        logger.info("Click in the 'Log In' button");
        logger.info("Type the username");
        logger.info("Type the password" );
        logger.info("Click the 'Log In' button");
        logger.info("Click in the top right button");
        logger.info("Click in the 'Account' button");
        logger.info("Click in the 'Account Settings' button");
        logger.info("Click in the 'Deactivate Account' button");
        logger.info("Click in the 'Deactivate' button");
    }

    @AfterTest
    @Parameters({"browser"})
    public void closeBrowser(String browser) {
        logger.info("Close" + browser);
    }

}
