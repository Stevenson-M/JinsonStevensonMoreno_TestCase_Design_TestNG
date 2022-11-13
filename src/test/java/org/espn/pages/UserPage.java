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

    @FindBy(id="BtnSubmit")
    private WebElement DeactivateAccountConfirmationButton;

    @FindBy(xpath = "root > div:nth-child(3) > div > div > div:nth-child(1)")
    private WebElement DeactivateModalMessageWindow;

    @FindBy(id = "BtnSubmit")
    private WebElement DeactivateModalMessageWindowButtonConfirmation;



    public void clickLoginButton() {
        clickElement(loginUserMenuButton);
    }

    public boolean checkNavUserMenuWelcomeText(String text) {
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
    String PrincipalWindow = getDriver().getWindowHandle();
    public void switchToConfirmationDeactivatePopUp(){
        waitForVisibility(DeactivateModalMessageWindow);

        Set<String> windowHandles = getDriver().getWindowHandles();
        Iterator<String> i1 = windowHandles.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!PrincipalWindow.equalsIgnoreCase(ChildWindow)) {
                getDriver().switchTo().window(ChildWindow);

                getDriver().close();
            }
        }
        getDriver().switchTo().window(PrincipalWindow);
    }

    public boolean checkDeactivateModalMessageWindowIsPresent(){
        return DeactivateModalMessageWindow.isDisplayed();
    }

    public void clickDeactivateModalMessageWindowButtonConfirmation() {
        clickElement(DeactivateModalMessageWindowButtonConfirmation);
    }

    public UserPage(WebDriver driver) {
        super(driver);
    }


}
