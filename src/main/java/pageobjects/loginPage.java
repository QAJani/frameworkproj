package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-email")
    private WebElement emailAddressField;

    @FindBy(id = "input-password")
    private WebElement passwordAddressField;

    @FindBy(css = "input[value='Login'] ")
    private WebElement button;

    public WebElement emailAddressField() {
        return emailAddressField;
    }

    public WebElement passwordAddressField() {
        return passwordAddressField;
    }

    public WebElement button() {
        return button;
    }
}
