package org.espn.tests;

import org.espn.pages.MainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;

public class EspnLogoutTest extends BaseTest {

    @Test
    @Parameters({"email", "password"})
    public void logOutTest(String email, String password) {
        MainPage mainPage = new MainPage(driver.getDriver());
        mainPage.clickGlobalUserMenu();
        mainPage.clickLoginUserMenuButton();
        mainPage.changeToIframe();
        mainPage.clickEmailInput();
        mainPage.typeEmailInput(email);
        mainPage.clickPasswordInput();
        mainPage.typePasswordInput(password);
        mainPage.clickLoginButton();
        mainPage.hoverGlobalUserMenu();
        mainPage.clickLogOutButton();
        mainPage.refreshPage();
        mainPage.hoverGlobalUserMenu();
        checkThat("User Menu has a welcome message without the name of the user", mainPage.checkNavUserMenuWelcomeText(), is("Welcome!"));
        checkThat("Login Button Is Present And Visible", mainPage.checkLogInButtonIsPresent(), is(true));
    }
}