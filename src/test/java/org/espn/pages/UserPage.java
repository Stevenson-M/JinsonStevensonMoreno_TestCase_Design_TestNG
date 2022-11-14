package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.Set;

public class UserPage extends BasePage {

    @FindBy(css="div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement loginUserMenuButton;

    @FindBy(css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement LogOutButton;

    @FindBy (css = "div.global-user:last-child ul.account-management li.display-user")
    private WebElement NavUserMenuWelcomeText;

    @FindBy(css="li:nth-child(2) a[tref='/members/v3_1/modifyAccount']")
    private WebElement espnProfile;

    String SettingsIframe = "oneid-iframe";

    @FindBy(id="AccountDeleteLink")
    private WebElement DeactivateAccountButton;

    @FindBy(css = "#TextBlock + #BtnSubmit")
    private WebElement DeactivateAccountConfirmationButton;

    @FindBy (css = "#TextError + #BtnSubmit")
    private  WebElement DeactivateAccountConfirmationIframe;

    @FindBy (css = ".account-deleted-gating + #Title")
    private  WebElement deleteAccountConfirmationTextWhenLogIn;

    public void clickLoginButton() {
        clickElement(loginUserMenuButton);
    }

    public Boolean checkNavUserMenuWelcomeText(String text) {
        return NavUserMenuWelcomeText.getText().contains(text);
    }

    public void clickLogOutButton() {
        clickElement(LogOutButton);
    }

    public boolean checkLogInButtonIsPresent(){
        return loginUserMenuButton.isEnabled();
    }

    public void clickEspnProfile() {
        clickElement(espnProfile);
    }

    public void changeToSettingsIframe(){
        getDriver().switchTo().frame(SettingsIframe);
    }

    public void clickDeactivateAccountButton() {
        clickElement(DeactivateAccountButton);
    }

    public void clickDeactivateAccountConfirmationButton() {
        clickElement(DeactivateAccountConfirmationButton);
    }

    public void clickDeactivateAccountConfirmationIframe() {
        clickElement(DeactivateAccountConfirmationIframe);
    }

    public void goOutFromDeactivateAccountConfirmationIframe() {
        super.getDriver().switchTo().defaultContent();
    }

    public boolean deleteAccountConfirmationTextWhenLogIn(String text) {
        waitForVisibility(deleteAccountConfirmationTextWhenLogIn);
        return deleteAccountConfirmationTextWhenLogIn.getText().contains(text);
    }


    public UserPage(WebDriver driver) {
        super(driver);
    }


}
