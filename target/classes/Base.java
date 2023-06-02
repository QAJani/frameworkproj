package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
    WebDriver driver = null;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {

        prop = new Properties();
        String propertiesPath = System.getProperty("user.dir")
                + "/src/main/java/resources/data.properties";

        FileInputStream fis = new FileInputStream(propertiesPath);
        prop.load(fis);

        String browsername = prop.getProperty("browser");

        if (browsername.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browsername.equalsIgnoreCase("Safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else if (browsername.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new InvalidParameterException("Unknown Browser");
        }
        driver.manage().window().maximize();
        return driver;

    }

    public String takeScreenshot(String testName, WebDriver driver) throws IOException {

        File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationFilePath = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
        FileUtils.copyFile(SourceFile, new File(destinationFilePath));

        return destinationFilePath;
    }
}
