package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

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

    public void changeToIframe(){
        getDriver().switchTo().frame(loginIframe);
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

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
