package org.espn.tests;

import org.espn.pages.BasePage;
import org.espn.pages.LoginPage;
import org.espn.pages.UserPage;
import org.espn.pages.WatchPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;

public class EspnTest extends BaseTest {

    @Test
    @Parameters({"email", "password"})
    public void loginTest(String email, String password) {
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
        BasePage MainPage2 = new BasePage(driver.getDriver());
        MainPage2.goToWatchPage();
        WatchPage watchPage = new WatchPage(driver.getDriver());
        checkThat("There is at least one carousel displayed", watchPage.checkCarouselsArePresent(), is(true));

        watchPage.clickSecondCarouselItem();









    }



}
