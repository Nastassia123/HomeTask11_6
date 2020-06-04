package pages;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class LoginPage extends MainPage {

    private static final By EMAIL_FIELD = By.id("exampleInputEmail1");

    private static final By PASSWORD_FIELD = By.id("exampleInputPassword1");


    public PersonalAreaPage fillOutLoginInformation(User user) {
        WebElement emailField = waitForExpectedElement(EMAIL_FIELD);
        emailField.sendKeys(user.getUsername(), Keys.ENTER);
        WebElement passwordField = waitForExpectedElement(PASSWORD_FIELD);
        passwordField.sendKeys(user.getPassword(), Keys.ENTER);
        waitPageIsLoadedAndJQueryIsProcessed();
        logger.info("User" + user.getUsername() + "is successfully logged in ");
        return new PersonalAreaPage();
    }


    public boolean isLoginPageHeaderDisplayed() {
        return isElementDisplayed(By.xpath("//a[contains(text(), 'Вход')]"));
    }
}


