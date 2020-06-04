package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.PersonalAreaPage;
import service.UserCreator;


public class VerifyLoginFunctionality extends MainPage {


    @Parameters ({"Login/Registration"})
    @Test
    public void testLoginOption(String tab) {
        User testUser = UserCreator.withCredentialsFromProperty();
        PersonalAreaPage loginPage = new MainPage()
                .openHomePage()
                .openLoginPage(tab)
                .fillOutLoginInformation(testUser);
               // .fillOutEmailField()
               // .fillOutPasswordField();
        Assert.assertEquals(loginPage.personalPageHeader().getText(),"Подписка");
    }
    }

