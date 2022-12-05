package org.espn.tests;

import org.espn.pages.MainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.is;

public class EspnDeactivateAccountTest extends BaseTest {

    @Test
    @Parameters({"email", "password"})
    public void EspnDeactivateAccountTest(String email, String password) {
        MainPage mainPage = new MainPage(driver.getDriver());
        mainPage.clickGlobalUserMenu();
        mainPage.clickLoginUserMenuButton();
        mainPage.changeToIframe();
        mainPage.clickEmailInput();
        mainPage.typeEmailInput(email);
        mainPage.clickPasswordInput();
        mainPage.typePasswordInput(password);
        mainPage.clickLoginButton();
        mainPage.waitForGlobalUserMenu();
        mainPage.hoverGlobalUserMenu();
        mainPage.clickEspnProfile();
        mainPage.changeToIframe();
        mainPage.waitForIframeDeleteVisibility();
        mainPage.clickDeactivateAccountButton();
        mainPage.clickDeactivateAccountConfirmationButton();
        mainPage.clickDeactivateAccountConfirmationIframe();
        mainPage.goOutFromDeactivateAccountConfirmationIframe();
        mainPage.refreshPage();
        mainPage.waitForGlobalUserMenu();
        mainPage.hoverGlobalUserMenu();
        mainPage.clickLoginUserMenuButton();
        mainPage.changeToIframe();
        mainPage.clickEmailInput();
        mainPage.typeEmailInput(email);
        mainPage.clickPasswordInput();
        mainPage.typePasswordInput(password);
        mainPage.clickLoginButton();
        checkThat("Account deactivated text is present when you try to log in", mainPage.isAccountDeactivated(), is(true));
    }
}