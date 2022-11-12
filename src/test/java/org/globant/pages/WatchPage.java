package org.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WatchPage extends BasePage {

    @FindBy(className = "MediaPlaceholder relative MediaPlaceholder--16x9 cursor-pointer MediaPlaceholder--button-hover WatchTile__Image WatchTile__Image--16x9")
    private WebElement SecondCarrouselCard;


    @FindBy(className ="icon--color icon__svg icon__svg--dark")
    private WebElement CloseIframeButton;


    /**Validar que almenos un carrusel esta presente*/



    public void clickSecondCarrouselCard() {
        clickElement(SecondCarrouselCard);
    }

    public void checkCloseIframeButtonIsPresent(){
        checkElementIsPresent(CloseIframeButton);
    }

    public void clickCloseIframeButton() {
        clickElement(CloseIframeButton);
    }

    public WatchPage(WebDriver driver) {
        super(driver);
    }

    public void checkCarusselIsPresent() {

    }
}

