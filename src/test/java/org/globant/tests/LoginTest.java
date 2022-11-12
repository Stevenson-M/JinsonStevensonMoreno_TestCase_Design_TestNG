package org.globant.tests;

import org.globant.pages.BasePage;
import org.globant.pages.LoginPage;
import org.globant.pages.UserPage;
import org.globant.pages.WatchPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        BasePage MainPage = new BasePage(driver.getDriver());
        MainPage.clickGlobalUserMenu();
        UserPage userPage = new UserPage(driver.getDriver());
        userPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver.getDriver());
        loginPage.changeToIframe();
        loginPage.checkEspnLogoIsPresent();
        loginPage.checkSingUpButtonIsPresent();
        loginPage.checkLoginButtonIsPresent();
        loginPage.clickEmailInput();
        loginPage.typeEmailInput("stevensonpruebaespn@gmail.com");
        loginPage.clickPasswordInput();
        loginPage.typePasswordInput("Prueba1ESPN");
        loginPage.clickLoginButton();
        BasePage MainPage2 = new BasePage(driver.getDriver());
        MainPage2.clickWatchButton();
        WatchPage watchPage = new WatchPage(driver.getDriver());
        /**Check carussel*/
        watchPage.clickSecondCarrouselCard();
        watchPage.checkCloseIframeButtonIsPresent();
        watchPage.clickCloseIframeButton();
        watchPage.goToUrl(driver.getDriver().getCurrentUrl());



    }

}
