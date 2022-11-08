package com.globant;

import org.testng.annotations.*;

import java.util.logging.Logger;

public class LoginTest extends CommonTestClass {
    Logger logger = Logger.getLogger(this.getClass().getName());

    @Test
    public void loginTest() {
        logger.info("Click in the top right button");
        logger.info("Click in the 'Log In' button");
        logger.info("Type the username");
        logger.info("Type the password" );
        logger.info("Click the 'Log In' button");
    }

}





