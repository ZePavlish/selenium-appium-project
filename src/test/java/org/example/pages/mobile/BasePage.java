package org.example.pages.mobile;

import org.example.utils.AppiumDriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = AppiumDriverManager.getDriver();
        this.wait = AppiumDriverManager.getWait();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
}