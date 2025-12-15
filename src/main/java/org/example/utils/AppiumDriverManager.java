package org.example.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URI;
import java.time.Duration;

public class AppiumDriverManager {
    private static AndroidDriver driver;
    private static WebDriverWait wait;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                // Установите jdk-http-client или уберите эту настройку
                System.setProperty("webdriver.http.factory", "jdk-http-client");

                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android");
                options.setPlatformVersion("11.0");
                options.setDeviceName("Android Emulator");
                options.setAutomationName("UiAutomator2");
                options.setNoReset(true);

                // Укажите путь к APK или используйте установленное приложение
                // options.setApp("C:\\path\\to\\wikipedia.apk");
                // ИЛИ используйте уже установленное приложение:
                options.setAppPackage("org.wikipedia");
                options.setAppActivity("org.wikipedia.main.MainActivity");

                URI appiumServerUri = new URI("http://127.0.0.1:4723");
                driver = new AndroidDriver(appiumServerUri.toURL(), options);

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            } catch (Exception e) {
                System.err.println("Failed to initialize Appium driver: " + e.getMessage());
                System.err.println("Make sure Appium server is running on port 4723");
                throw new RuntimeException("Failed to initialize Appium driver", e);
            }
        }
        return driver;
    }

    public static WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        }
        return wait;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            wait = null;
        }
    }
}