package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends BasePage {

    @FindBy(css="div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement loginUserMenuButton;

    public void clickLoginButton() {
        clickElement(loginUserMenuButton);
    }

    public UserPage(WebDriver driver) {
        super(driver);
    }

}
