package com.udemy.java.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.function.Predicate;
public class PaymentScreenPageObject {
    private final WebDriver driver;
    @FindBy(id = "coupon")
    private WebElement couponfield;
    @FindBy(id = "couponbtn")
    private WebElement couponbtn;
    @FindBy(id = "cc")
    private WebElement cc;
    @FindBy(id = "year")
    private WebElement year;
    @FindBy(id = "cvv")
    private WebElement cvv;
    @FindBy(id = "price")
    private WebElement price;
    @FindBy(id = "status")
    private WebElement status;
    @FindBy(id = "buy")
    private WebElement buy;
    public PaymentScreenPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-payment-screen.html");
    }
    public void applyPromoCode(String couponCode) {
        this.couponfield.sendKeys(couponCode);
        this.couponbtn.click();
    }
    public void enterCardDetails(String ccNumber, String year, String cvv) {
        this.cc.sendKeys(ccNumber);
        this.year.sendKeys(year);
        this.cvv.sendKeys(cvv);
    }
    public void buynow() {
        this.buy.click();
    }
    public String verifyStatus() {
        return this.status.getText().trim();
    }
}
