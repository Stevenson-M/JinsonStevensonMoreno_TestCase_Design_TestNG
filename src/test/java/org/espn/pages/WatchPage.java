package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WatchPage extends BasePage {

    @FindBy(css = "section.Carousel")
    private List<WebElement> carousels;

    @FindBy(xpath = "//div[@class='Carousel__Wrapper relative Carousel__Wrapper--canScrollRight']//li[1]//a[1]//div[1]//figure[1]//div[2]//picture[1]//img[1]")
    private WebElement secondCarouselItem;


    public Boolean checkCarouselsArePresent() {
        return carousels.size() > 0;
    }

    /**check carousel cards have a title and a description*/
    public Boolean checkCarouselCardsHaveTitleAndDescription() {
        return secondCarouselItem.isDisplayed();
    }



    public void clickSecondCarouselItem() {
        clickElement(secondCarouselItem);
    }








    public WatchPage(WebDriver driver) {
        super(driver);
    }


}

