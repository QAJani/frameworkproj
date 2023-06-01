package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Base;

public class Twotest extends Base {
    @Test
    public void testwo() throws IOException, InterruptedException {
        System.out.println("Test Two");
        WebDriver driver = initializeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        Thread.sleep(3000);
        Assert.assertTrue(false);
        driver.close();
    }
}
