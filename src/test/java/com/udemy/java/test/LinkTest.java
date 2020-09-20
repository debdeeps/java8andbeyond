package com.udemy.java.test;
import com.udemy.java.stream.LinkUtil;
import com.udemy.java.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
public class LinkTest {
    private WebDriver driver;
    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }
    @Test
    public void googleTest() {
        this.driver.get("https://www.google.com/");
        System.out.println("Before::" + LocalDateTime.now());
        List<WebElement> elements = this.driver.findElements(By.xpath("//*[@href]"));
        List<String> result = elements.stream()
                .parallel()
                .map(s -> s.getAttribute("href"))
                .filter(s -> LinkUtil.getResponseCode(s) != 200)
                .collect(Collectors.toList());
        System.out.println("After::" + LocalDateTime.now());
    }
    @AfterTest
    public void closeBrowser() {
        this.driver.quit();
    }
}
