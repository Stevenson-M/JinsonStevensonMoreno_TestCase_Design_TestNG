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

    public Boolean checkCarouselsArePresent() {
        return carousels.size() > 0;
    }

    @FindBy(xpath = "//div[@class='Carousel__Wrapper relative Carousel__Wrapper--canScrollRight']//li[1]//a[1]//div[1]//figure[1]//div[2]//picture[1]//img[1]")
    private WebElement secondCarouselItem;

    @FindBy(xpath = "fittPortal_6 > div > div > section > header > button > div")
    private WebElement closeSecondCarouselItem;


    public void clickSecondCarouselItem() {
        clickElement(secondCarouselItem);
    }

    public void returnToMainPage() {
        getDriver().navigate().back();
    }



    /****/














    public WatchPage(WebDriver driver) {
        super(driver);
    }


}

