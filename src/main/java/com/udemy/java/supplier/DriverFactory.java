package com.udemy.java.supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
public class DriverFactory {
    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        System.setProperty("webdriver.chrome.driver", "E:\\Users\\Debdeep\\Downloads\\Compressed\\chromedriver.exe");
        return new ChromeDriver();
    };
    private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        System.setProperty("webdriver.gecko.driver", "E:\\Users\\Debdeep\\Downloads\\Compressed\\geckodriver.exe");
        return new FirefoxDriver();
    };
    private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();
    static {
        MAP.put("chrome", chromeDriverSupplier);
        MAP.put("firefox", firefoxDriverSupplier);
    }
    public static WebDriver getDriver(String browser) {
        return MAP.get(browser).get();
    }
}
