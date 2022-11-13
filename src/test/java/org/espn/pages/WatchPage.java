package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WatchPage extends BasePage {

    @FindBy(css = "section.Carousel")
    private List<WebElement> carousels;

    @FindBy(css = "div.Carousel__Wrapper--canScrollRight ul.Carousel__Inner li:nth-child(2) > a")
    private WebElement secondCarouselCard;

    @FindBy (css = "section.lightbox__contentBox")
    private WebElement CarouselPopUp;

    @FindBy (css = "svg.icon--color")
    private WebElement CloseButtonCarouselPopUp;

    public Boolean checkCarouselsArePresent() {
        return carousels.size() > 0;
    }

    public void clickSecondCarouselCard() {
        clickElement(secondCarouselCard);
    }

    String MainWindow = getDriver().getWindowHandle();

    public void switchToCarouselPopUp(){
        waitForVisibility(CarouselPopUp);

        Set<String> windowHandles = getDriver().getWindowHandles();
        Iterator<String> i1 = windowHandles.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                getDriver().switchTo().window(ChildWindow);

                getDriver().close();
            }
        }
        getDriver().switchTo().window(MainWindow);
    }

    public boolean checkCarouselCloseBottomPopUpIsPresent() {
        return CloseButtonCarouselPopUp.isDisplayed();
    }

    public void clickCloseButtonCarouselPopUp() {
        clickElement(CloseButtonCarouselPopUp);
    }

    public void returnToMainPage() {
        getDriver().navigate().back();
    }

    public WatchPage(WebDriver driver) {
        super(driver);
    }

}
