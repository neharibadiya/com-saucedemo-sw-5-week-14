package com.saucedemo.testsuite;

import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity","regression"})
    @Parameters({"Email","Password"})
    public void userShouldLoginSuccessfullyWithValidCredentials(String email,String password){
        loginPage.enterEmailId(email);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(homePage.getHeadingText(),"Products","User login not success");
    }
    @Test(groups = {"smoke","regression"})
    @Parameters({"Email","Password"})
    public void verifyThatSixProductsAreDisplayedOnPage(String email,String password) {
        loginPage.enterEmailId(email);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(homePage.countingItems(),6,"Products are not displayed correctly");
    }
}
