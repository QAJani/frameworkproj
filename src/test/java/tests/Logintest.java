package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    Logger log;

    @BeforeMethod
    public void openApplication() throws IOException {
        log = LogManager.getLogger(Logintest.class.getName());
        driver = initializeDriver();
        log.debug("Browser got launched");
        driver.get(prop.getProperty("url"));
        log.debug("Navigated to application URL");
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
        log.debug("Clicked on My Account dropdown");

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
        log.debug("Browser got closed");
    }

    @DataProvider
    public Object[][] getLoginData() {
        Object[][] data = { { "testy@test1.com", "test", "Failure" }, { "tosty@tost.com", "tost", "Successfull" } };
        return data;
    }

}
