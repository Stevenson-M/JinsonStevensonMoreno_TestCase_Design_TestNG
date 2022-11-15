package org.espn.tests;

import org.espn.pages.MainPage;
import org.espn.pages.WatchPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;

public class EspnLoginTest extends BaseTest {

    @Test
    @Parameters({"email", "password"})
    public void EspnLoginTest(String email, String password) {
        MainPage mainPage = new MainPage(driver.getDriver());
        mainPage.clickGlobalUserMenu();
        mainPage.clickLoginUserMenuButton();
        mainPage.changeToIframe();
        checkThat("ESPN Logo Is Present And Visible", mainPage.checkEspnLogoIsPresent(), is(true));
        checkThat("Sing Up Button Is Present And Visible", mainPage.checkSingUpButtonIsPresent(), is(true));
        checkThat("Login Button Is Present And Visible", mainPage.checkLoginButtonIsPresent(), is(true));
        mainPage.clickEmailInput();
        mainPage.typeEmailInput(email);
        mainPage.clickPasswordInput();
        mainPage.typePasswordInput(password);
        mainPage.clickLoginButton();
        mainPage.goToWatchPage();
        WatchPage watchPage = new WatchPage(driver.getDriver());
        checkThat("There is at least one carousel displayed", watchPage.checkCarouselsArePresent(), is(true));
        checkThat("The carousel cards have a title", watchPage.checkAllCarouselCardsTitleIsPresent(), is(true));
        checkThat("The carousel cards have a description", watchPage.checkAllCarouselCardsDescriptionIsPresent(), is(true));
        watchPage.refreshPage();
        watchPage.clickSecondCarouselCard();
        watchPage.switchToCarouselPopUp();
        checkThat("Carousel the close button in the carousel pop up is present and visible", watchPage.checkCarouselCloseBottomPopUpIsPresent(), is(true));
        watchPage.clickCloseButtonCarouselPopUp();
        watchPage.returnToMainPage();
        MainPage mainPage2 = new MainPage(driver.getDriver());
        mainPage2.hoverGlobalUserMenu();
        checkThat("User Menu has a welcome message with the name of the user", mainPage2.checkNavUserMenuWelcomeText(), is(WelcomeMessageInNav));
        mainPage2.clickLogOutButton();
        mainPage2.refreshPage();
        mainPage2.hoverGlobalUserMenu();
        checkThat("User Menu has a welcome message without the name of the user", mainPage2.checkNavUserMenuWelcomeText(), is("Welcome!"));
    }
}
