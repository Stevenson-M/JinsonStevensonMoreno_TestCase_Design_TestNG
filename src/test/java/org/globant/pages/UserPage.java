package org.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends BasePage {

    @FindBy(css="div[class='global-user'][style^='left'] a[data-affiliatename='espn']")
    private WebElement loginUserMenuButton;

    public void clickLoginButton() {
        clickElement(loginUserMenuButton);
    }

    public UserPage(WebDriver driver) {
        super(driver);
    }

}
