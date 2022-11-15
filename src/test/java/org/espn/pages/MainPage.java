package org.espn.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(id = "global-user-trigger")
    private WebElement globalUserMenu;

    @FindBy(css = "body.index.desktop.page-context-top.qa:nth-child(2) div.hidden-print:nth-child(3) header.espn-en.user-account-management.has-search nav:nth-child(3) ul.espn-en li.pillar.watch:nth-child(11) > a:nth-child(1)")
    private WebElement watchButton;

    @FindBy(css="div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement loginUserMenuButton;

    @FindBy(css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement LogOutButton;

    @FindBy (css = "div.global-user:last-child ul.account-management li.display-user")
    private WebElement NavUserMenuWelcomeText;

    @FindBy(css="li:nth-child(2) a[tref='/members/v3_1/modifyAccount']")
    private WebElement espnProfile;

    @FindBy(id="AccountDeleteLink")
    private WebElement DeactivateAccountButton;

    @FindBy(css = "#TextBlock + #BtnSubmit")
    private WebElement DeactivateAccountConfirmationButton;

    @FindBy (css = "#TextError + #BtnSubmit")
    private  WebElement DeactivateAccountConfirmationIframe;

    @FindBy (css = ".account-deleted-gating + #Title")
    private  WebElement deleteAccountConfirmationTextWhenLogIn;

    @FindBy(css="input[type='email']")
    private WebElement EmailInput;

    @FindBy(id = "InputPassword")
    private WebElement PasswordInput;

    @FindBy(id = "BtnSubmit")
    private WebElement LoginButton;

    @FindBy(id = "logo")
    private WebElement EspnLogo;

    @FindBy(id = "BtnCreateAccount")
    private WebElement SingUpButton;

    String loginIframe = "oneid-iframe";

    public void clickGlobalUserMenu() {
        clickElement(globalUserMenu);
    }

    public void clickWatchButton() {
        clickElement(watchButton);
    }

    public WatchPage goToWatchPage() {
        clickWatchButton();
        return new WatchPage(getDriver());
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }
    public void waitForGlobalUserMenu() {
        waitForVisibility(this.globalUserMenu);
    }

    public void hoverGlobalUserMenu() {
        hoverElement(globalUserMenu);
    }

    public void clickLoginUserMenuButton() {
        clickElement(loginUserMenuButton);
    }

    public String checkNavUserMenuWelcomeText() {
        return NavUserMenuWelcomeText.getText();
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

    public void clickDeactivateAccountButton() {
        waitForVisibility(DeactivateAccountButton);
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

    public String deleteAccountConfirmationTextWhenLogIn() {
        waitForVisibility(deleteAccountConfirmationTextWhenLogIn);
        return deleteAccountConfirmationTextWhenLogIn.getText();
    }

    public void changeToIframe(){
        getDriver().switchTo().frame(loginIframe);
    }

    public void waitForIframeDeleteVisibility(){
        waitForClickable(DeactivateAccountButton);
    }

    public boolean checkEspnLogoIsPresent(){
        return EspnLogo.isDisplayed();
    }

    public boolean checkSingUpButtonIsPresent(){
        return SingUpButton.isDisplayed();
    }

    public boolean checkLoginButtonIsPresent(){
        return LoginButton.isDisplayed();
    }

    public void clickEmailInput() {
        clickElement(EmailInput);
    }

    public void clickPasswordInput() {
        clickElement(PasswordInput);
    }

    public void typeEmailInput(String text) {
        typeOnInput(EmailInput, text);
    }

    public void typePasswordInput(String text) {
        typeOnInput(PasswordInput, text);
    }

    public void clickLoginButton() {
        clickElement(LoginButton);
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }
}