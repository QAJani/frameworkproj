package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
    public WebDriver initializeBrowser() {
        WebDriver driver = null;
        String browsername = "chromedriver";
        if (browsername.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browsername.equalsIgnoreCase("Safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else if (browsername.equalsIgnoreCase("ChromeDriver")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }
}
