package com.udemy.java.test;
import com.udemy.java.pages.DemoTableHomePage;
import com.udemy.java.pages.PaymentScreenActions;
import com.udemy.java.pages.PaymentScreenPageObject;
import com.udemy.java.supplier.DriverFactory;
import com.udemy.java.supplier.SearchCriteriaFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
public class PaymentScreenTest {
    private WebDriver driver;
    private PaymentScreenPageObject paymentScreenPageObject;
    private PaymentScreenActions paymentScreenActions;
    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
        this.paymentScreenPageObject = new PaymentScreenPageObject(driver);
    }
    @Test(dataProvider = "data")
    public void paymentTest(Consumer<PaymentScreenPageObject> con) {
        paymentScreenPageObject.goTo();
        con.accept(paymentScreenPageObject);
    }
    @DataProvider(name = "data")
    public Object[] getData() {
        return new Object[]{
                PaymentScreenActions.freeCoupon.andThen(PaymentScreenActions.Buy).andThen(PaymentScreenActions.successfulPurchase),
                PaymentScreenActions.discountedCoupon.andThen(PaymentScreenActions.validCC).andThen(PaymentScreenActions.Buy).andThen(PaymentScreenActions.successfulPurchase),
                PaymentScreenActions.validCC.andThen(PaymentScreenActions.Buy).andThen(PaymentScreenActions.successfulPurchase),
                PaymentScreenActions.invalidCC.andThen(PaymentScreenActions.Buy).andThen(PaymentScreenActions.failedPurchase),
                PaymentScreenActions.discountedCoupon.andThen(PaymentScreenActions.invalidCC).andThen(PaymentScreenActions.Buy).andThen(PaymentScreenActions.failedPurchase),
        };
    }
    @AfterTest
    public void closeBrowser() {
        this.driver.quit();
    }
}
