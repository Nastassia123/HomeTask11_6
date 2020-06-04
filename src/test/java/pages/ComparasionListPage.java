package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ComparasionListPage extends MainPage {

    private static final By BUY_BUTTON_XPATH = By.xpath("//div[contains(@class, 'item-buttons center-block')]//a[contains(@class, 'item-buy-btn item-buy-small-btn')]");

    private static final By CLOSE_BUTTON_WINDOW_LOCATOR = By.xpath("//div[@id='notification-type']//button[contains(@class,'close')]");


    public boolean isComparasionListPageHeaderDisplayed() {
        return isElementDisplayed(By.xpath("//h1[contains(text(), 'Сравнение товаров')]"));
    }

     public ComparasionListPage clickOnTheBuyButton(){
         WebElement buyButton = waitForExpectedElement(BUY_BUTTON_XPATH);
         buyButton.click();
         waitPageIsLoadedAndJQueryIsProcessed();
        return this;
     }

    public ComparasionListPage closePopUpWindow() {
        WebElement closeButton = waitForExpectedElement(CLOSE_BUTTON_WINDOW_LOCATOR);
        closeButton.click();
        waitPageIsLoadedAndJQueryIsProcessed();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }


    public WebElement elementsAddedInComparasionListPage() {
        return driver.findElement(By.xpath("//label[contains(text(), 'Товары для сравнения')]"));

    }

}
