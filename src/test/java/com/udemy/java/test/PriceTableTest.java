package com.udemy.java.test;
import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.java.pages.DemoTableHomePage;
import com.udemy.java.pages.PriceTablePageObject;
import com.udemy.java.supplier.DriverFactory;
import com.udemy.java.supplier.SearchCriteriaFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
public class PriceTableTest {
    private WebDriver driver;
    private PriceTablePageObject priceTablePageObject;
    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
        this.priceTablePageObject = new PriceTablePageObject(driver);
    }
    @Test
    public void PriceTest() {
//        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
        priceTablePageObject.goTo();
        priceTablePageObject.selectRadioButton();
        Assert.assertEquals(priceTablePageObject.getStatus(), "PASS");
        Uninterruptibles.sleepUninterruptibly(3000, TimeUnit.MILLISECONDS);
    }
    @AfterTest
    public void closeBrowser() {
        this.driver.quit();
    }
}
