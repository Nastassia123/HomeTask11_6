package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.User;
import org.testng.Assert;
import pages.*;
import service.UserCreator;

public class ShopStepDefs {

    private MainPage mainPage = new MainPage();
    private ComparasionListPage comparasionListPage = new ComparasionListPage();
    private WishListPage wishListPage = new WishListPage();
    private BasketPage basketPage = new BasketPage();

    @Given("^I opened 4FRAG home page$")
    public void iOpenedHomePage() {
        mainPage.openHomePage();
    }

    @When("^I search \"([^\"]*)\"$")
    public void iSearch(String product) {
        mainPage.findProductWIthSearchField(product);
    }

    @When("^I add \"([^\"]*)\" to the wish list page$")
    public void iAddItemToTheWishListPage(String item) {
        mainPage.addProductToWishListFromResultList(item);
    }

   @Then("^\"([^\"]*)\" is on the wish list page$")
    public void isOnWishListPage(String item) {
        Assert.assertTrue(wishListPage.isProductInTheWithListPageDisplayed(item),
              "The product " + item + " wasn't displayed on the with list page");
    }

    @Then("^\"([^\"]*)\" is on the basket page$")
    public void isOnBookMarksPage(String item) {
        Assert.assertTrue(basketPage.isProductInTheBasketPageDisplayed(item),
                "The product " + item + " wasn't displayed on the basket page");
    }


    @When("^I log in to the site using header tab \"([^\"]*)\"$")
    public void iLogInToSiteUsingHeaderTab(String loginTabLabel) {
        User testUser = UserCreator.withCredentialsFromProperty();
        PersonalAreaPage loginPage = new MainPage()
                .openHomePage()
                .openLoginPage(loginTabLabel)
                .fillOutLoginInformation(testUser);
        Assert.assertEquals(loginPage.personalPageHeader().getText(), "Подписка");
    }

    @When("^I close \"([^\"]*)\" notification pop-up$")
    public void iCloseNotificationPopUp(String popUpTitle) {
        mainPage.notificationPopUpCloseButton(popUpTitle).click();
        mainPage.waitPageIsLoadedAndJQueryIsProcessed();
    }

    @When("^I open tab \"([^\"]*)\"$")
    public void iOpenTab(String tab) {
        mainPage.headerTab(tab).click();
        mainPage.waitPageIsLoadedAndJQueryIsProcessed();
    }

    @When("I add \"([^\"]*)\" to the comparasion list page")
    public void iAddToTheComparasionListPage(String item) {

            mainPage.addProductToComparasionListFromResultList(item);
        mainPage.waitPageIsLoadedAndJQueryIsProcessed();
    }

    @When("I click on 'Buy' button")
    public void iClickOnButton() {
       comparasionListPage.clickOnTheBuyButton();
       comparasionListPage.waitPageIsLoadedAndJQueryIsProcessed();

    }

    @Then("I see \"([^\"]*)\" in the Basket page")
    public void iSeeInThePage(String item) {
        Assert.assertTrue(basketPage.isProductInTheBasketPageDisplayed(item),
                "The product "+ " wasn't displayed on the with list page");
    }
}
