package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends BasePage {

    @FindBy(css="div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement loginUserMenuButton;

    @FindBy(css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement LogOutButton;

    @FindBy (css = "div.global-user:last-child ul.account-management li.display-user")
    private WebElement NavUserMenuWelcomeText;

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

    public UserPage(WebDriver driver) {
        super(driver);
    }

}
