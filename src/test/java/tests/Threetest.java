package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class Threetest extends Base {
    @Test
    public void testwo() throws IOException, InterruptedException {
        System.out.println("Test Three");
        WebDriver driver = initializeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        Thread.sleep(3000);
        driver.close();
    }
}
