package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.accountpage;
import pageobjects.landingPage;
import pageobjects.loginPage;
import resources.*;

public class Logintest extends Base {
    WebDriver driver;

    @BeforeMethod
    public void openApplication() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test(dataProvider = "getLoginData")
    public void login(String email, String password, String expectedResult) {

        landingPage lp = new landingPage(driver);
        lp.myAccountDropdown().click();
        lp.loginOption().click();

        loginPage loginpage = new loginPage(driver);
        loginpage.emailAddressField().sendKeys(email);
        loginpage.passwordAddressField().sendKeys(password);
        loginpage.button().click();

        accountpage ap = new accountpage(driver);
        String actualResult;
        try {
            Assert.assertTrue(ap.editAccountInfoLink().isDisplayed());
            actualResult = "Successfull";
        } catch (Exception e) {
            actualResult = "Failure";
        }
        Assert.assertEquals(actualResult, expectedResult);

    }

    @AfterMethod
    public void closure() {
        driver.close();
    }

    @DataProvider
    public Object[][] getLoginData() {
        Object[][] data = { { "testy@test1.com", "test", "Failure" }, { "tosty@tost.com", "tost", "Successfull" } };
        return data;
    }

}
