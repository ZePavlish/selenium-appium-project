package org.example.utils;

import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        // Простые значения по умолчанию
        properties.setProperty("web.browser", "chrome");
        properties.setProperty("web.timeout", "10");
        properties.setProperty("web.base.url", "https://www.wikipedia.org");

        // Мобильные настройки
        properties.setProperty("mobile.appium.server.url", "http://127.0.0.1:4723");
        properties.setProperty("mobile.platform.name", "Android");
        properties.setProperty("mobile.platform.version", "11.0");
        properties.setProperty("mobile.device.name", "Android Emulator");
        properties.setProperty("mobile.automation.name", "UiAutomator2");
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}