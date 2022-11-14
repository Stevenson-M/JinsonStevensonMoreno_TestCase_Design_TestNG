package org.espn.tests;

import org.espn.pages.BasePage;
import org.espn.pages.LoginPage;
import org.espn.pages.UserPage;
import org.espn.pages.WatchPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;

public class EspnLoginTest extends BaseTest {

    @Test
    @Parameters({"email", "password"})
    public void EspnLoginTest(String email, String password) {
        BasePage mainPage = new BasePage(driver.getDriver());
        mainPage.clickGlobalUserMenu();
        UserPage userPage = new UserPage(driver.getDriver());
        userPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver.getDriver());
        loginPage.changeToIframe();
        checkThat("ESPN Logo Is Present And Visible", loginPage.checkEspnLogoIsPresent(), is(true));
        checkThat("Sing Up Button Is Present And Visible", loginPage.checkSingUpButtonIsPresent(), is(true));
        checkThat("Login Button Is Present And Visible", loginPage.checkLoginButtonIsPresent(), is(true));
        loginPage.clickEmailInput();
        loginPage.typeEmailInput(email);
        loginPage.clickPasswordInput();
        loginPage.typePasswordInput(password);
        loginPage.clickLoginButton();
        BasePage mainPage2 = new BasePage(driver.getDriver());
        mainPage2.goToWatchPage();
        WatchPage watchPage = new WatchPage(driver.getDriver());
        checkThat("There is at least one carousel displayed", watchPage.checkCarouselsArePresent(), is(true));
        checkThat("The carousel cards have a title", watchPage.checkAllCarouselCardsTitleIsPresent(), is(true));
        checkThat("The carousel cards have a description", watchPage.checkAllCarouselCardsDescriptionIsPresent(), is(true));
        watchPage.clickSecondCarouselCard();
        watchPage.switchToCarouselPopUp();
        checkThat("Carousel the close button in the carousel pop up is present and visible", watchPage.checkCarouselCloseBottomPopUpIsPresent(), is(true));
        watchPage.clickCloseButtonCarouselPopUp();
        watchPage.returnToMainPage();
        BasePage mainPage3 = new BasePage(driver.getDriver());
        mainPage3.hoverGlobalUserMenu();
        UserPage userPage2 = new UserPage(driver.getDriver());
        checkThat("User Menu has a welcome message with the name of the user", userPage2.checkNavUserMenuWelcomeText(WelcomeMessageInNav), is(true));
        userPage2.clickLogOutButton();
        BasePage mainPage4 = new BasePage(driver.getDriver());
        mainPage4.hoverGlobalUserMenu();
        UserPage userPage3 = new UserPage(driver.getDriver());
        checkThat("User Menu has a welcome message without the name of the user", userPage3.checkNavUserMenuWelcomeText(WelcomeMessageInNav), is(false));
    }
}
