package org.espn.tests;

import org.espn.pages.BasePage;
import org.espn.pages.LoginPage;
import org.espn.pages.UserPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;

public class EspnLogoutTest extends BaseTest {

    @Test
    @Parameters({"email", "password"})
    public void logOutTest(String email, String password) {
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
        userPage2.clickLogOutButton();
        BasePage mainPage3 = new BasePage(driver.getDriver());
        mainPage3.hoverGlobalUserMenu();
        UserPage userPage3 = new UserPage(driver.getDriver());
        checkThat("User Menu has a welcome message without the name of the user", userPage3.checkNavUserMenuWelcomeText(WelcomeMessageInNav), is(false));
        checkThat("Login Button Is Present And Visible", userPage3.checkLogInButtonIsPresent(), is(true));
    }
}