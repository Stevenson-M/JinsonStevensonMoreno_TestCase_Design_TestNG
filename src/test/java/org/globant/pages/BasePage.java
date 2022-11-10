package org.globant.pages;

import org.globant.configuration.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends WebOperations {

    @FindBy(id = "global-scoreboard")
    private WebElement globalScoreboard;

    @FindBy(id = "global-header")
    private WebElement globalHeader;

    @FindBy(id = "PageFooter_Footer")
    private WebElement pageFooter;

    public BasePage(WebDriver driver) {
        super(driver);
    }


}