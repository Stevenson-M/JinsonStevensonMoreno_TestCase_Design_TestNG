package org.globant.pages;

import org.globant.configuration.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class MainPage extends WebOperations{

    @FindBy(id = "global-header")
    private WebElement globalHeader;

    @FindBy(id = "global-user-trigger")
    private WebElement globalUserMenu;

    @FindBy(id = "global-viewport > div.global-user > div > ul.account-management > li:nth-child(7) > a")
    private WebElement loginButton;

    @FindBy(id = "InputLoginValue")
    private WebElement inputLogin;

    @FindBy(id = "InputPassword")
    private WebElement inputPassword;

    @FindBy(id = "btnSubmit")
    private WebElement loginButtonModal;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickGlobalUserMenu(){
        clickElement(globalUserMenu);
    }

    public void clickLoginButton(){
        waitForVisibility(loginButton);
        clickElement(loginButton);
    }

    public void typeOnInputLogin(String text){
        waitForVisibility(inputLogin);
        typeOnInput(inputLogin, text);
    }

    public void typeOnInputPassword(String text){
        typeOnInput(inputPassword, text);
    }

    public void clickLoginButtonModal(){
        clickElement(loginButtonModal);
    }


}
