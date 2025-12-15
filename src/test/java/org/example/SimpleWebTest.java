package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertTrue;

public class SimpleWebTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Для Java 25 используем jdk-http-client вместо netty
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testWikipedia() {
        driver.get("https://www.wikipedia.org");
        String title = driver.getTitle();
        System.out.println("Page title: " + title);
        assertTrue(title.contains("Wikipedia"),
                "Title should contain 'Wikipedia'. Actual: " + title);
        System.out.println("✓ Wikipedia test passed!");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed");
        }
    }
}