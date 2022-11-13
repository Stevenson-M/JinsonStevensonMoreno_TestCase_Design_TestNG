package org.espn.tests;

import org.espn.pages.BasePage;
import org.espn.pages.LoginPage;
import org.espn.pages.UserPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;

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


        /** TO WORK ON **/
        /** userPage2.switchToConfirmationDeactivatePopUp();
        checkThat("Deactivate modal message window is present", userPage2.checkDeactivateModalMessageWindowIsPresent(), is(true));
        userPage2.clickDeactivateModalMessageWindowButtonConfirmation(); **/

    }
}