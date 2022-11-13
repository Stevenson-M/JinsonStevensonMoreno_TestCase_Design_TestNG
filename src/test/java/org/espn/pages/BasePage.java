package org.espn.pages;

import org.espn.configuration.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends WebOperations {

    @FindBy(id = "global-header")
    private WebElement globalHeader;

    @FindBy(id = "global-user-trigger")
    private WebElement globalUserMenu;

    @FindBy(css = "body.index.desktop.page-context-top.qa:nth-child(2) div.hidden-print:nth-child(3) header.espn-en.user-account-management.has-search nav:nth-child(3) ul.espn-en li.pillar.watch:nth-child(11) > a:nth-child(1)")
    private WebElement watchButton;

    @FindBy(xpath = "//*[@id=\"global-header\"]/div[2]/ul/li[2]/div/div/ul[1]/li[1]/span")
    private WebElement navText;

    @FindBy(linkText = "Log Out")
    private WebElement LogOutButton;

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

    public void hoverGlobalUserMenu() {
        hoverElement(globalUserMenu);
    }

    public Boolean validateNavText(String text) {
            return navText.getText().contains(text);
        }

    public void clickLogOutButton() {
        clickElement(LogOutButton);
    }

    public BasePage(WebDriver driver) {
        super(driver);
    }
}