package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
    public WebDriver initializeDriver() throws IOException {
        WebDriver driver = null;

        Properties prop = new Properties();
        String propertiesPath = System.getProperty("user.dir") + "src/main/java/resources/data.properties";
        FileInputStream fis = new FileInputStream("propertiesPath");
        prop.load(fis);

        String browsername = prop.getProperty("browser");

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
