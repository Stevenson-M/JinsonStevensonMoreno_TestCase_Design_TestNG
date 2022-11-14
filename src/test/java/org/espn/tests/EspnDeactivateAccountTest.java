package org.espn.tests;

import org.espn.pages.BasePage;
import org.espn.pages.LoginPage;
import org.espn.pages.UserPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.is;

public class EspnDeactivateAccountTest extends BaseTest {

    @Test
    @Parameters({"email", "password"})
    public void EspnDeactivateAccountTest(String email, String password) {
        BasePage mainPage = new BasePage(driver.getDriver());
        mainPage.clickGlobalUserMenu();
        UserPage userPage = new UserPage(driver.getDriver());
        userPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver.getDriver());
        loginPage.changeToIframe();
        loginPage.clickEmailInput();
        loginPage.typeEmailInput(email);
        loginPage.clickPasswordInput();
        loginPage.typePasswordInput(password);
        loginPage.clickLoginButton();
        BasePage mainPage2 = new BasePage(driver.getDriver());
        mainPage2.hoverGlobalUserMenu();
        UserPage userPage2 = new UserPage(driver.getDriver());
        userPage2.clickEspnProfile();
        userPage2.changeToSettingsIframe();
        userPage2.clickDeactivateAccountButton();
        userPage2.clickDeactivateAccountConfirmationButton();
        userPage2.clickDeactivateAccountConfirmationIframe();
        userPage2.goOutFromDeactivateAccountConfirmationIframe();
        BasePage mainPage3 = new BasePage(driver.getDriver());
        mainPage3.refreshPage();
        mainPage3.waitForGlobalUserMenu();
        mainPage3.hoverGlobalUserMenu();
        UserPage userPage3 = new UserPage(driver.getDriver());
        userPage3.clickLoginButton();
        LoginPage loginPage2 = new LoginPage(driver.getDriver());
        loginPage2.changeToIframe();
        loginPage2.clickEmailInput();
        loginPage2.typeEmailInput(email);
        loginPage2.clickPasswordInput();
        loginPage2.typePasswordInput(password);
        loginPage2.clickLoginButton();
        checkThat("Account deactivated text is present when you try to log in", userPage3.deleteAccountConfirmationTextWhenLogIn(DeactivateAccountConfirmationTextWhenLogin), is(true));
    }
}