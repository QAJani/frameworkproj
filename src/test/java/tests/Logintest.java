package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pageobjects.accountpage;
import pageobjects.landingPage;
import pageobjects.loginPage;
import resources.*;

public class Logintest extends Base {
    WebDriver driver;

    @Test
    public void login() throws IOException, InterruptedException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));

        landingPage lp = new landingPage(driver);
        lp.myAccountDropdown().click();
        lp.loginOption().click();

        Thread.sleep(3000);

        loginPage loginpage = new loginPage(driver);
        loginpage.emailAddressField().sendKeys(prop.getProperty("email"));
        loginpage.passwordAddressField().sendKeys("password");
        loginpage.button().click();

        accountpage ap = new accountpage(driver);
        Assert.assertTrue(ap.editAccountInfoLink().isDisplayed());

    }

    // @AfterMethod
    // public void closure() {
    //     driver.close();
    // }

}
