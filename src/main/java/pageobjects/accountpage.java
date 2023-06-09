package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountpage {
    WebDriver driver;

    public accountpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Edit your account information']")
    private WebElement editAccountInfoLink;

    public WebElement editAccountInfoLink() {
        return editAccountInfoLink;
    }

}
