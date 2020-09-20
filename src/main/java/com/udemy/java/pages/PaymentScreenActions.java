package com.udemy.java.pages;
import org.testng.Assert;

import java.util.function.Consumer;
public class PaymentScreenActions {
    public static Consumer<PaymentScreenPageObject> freeCoupon = s -> s.applyPromoCode("FREEUDEMY");
    public static Consumer<PaymentScreenPageObject> discountedCoupon = s -> s.applyPromoCode("PARTIALUDEMY");
    public static Consumer<PaymentScreenPageObject> invalidCC = s -> s.enterCardDetails("4111111111111112", "2021", "123");
    public static Consumer<PaymentScreenPageObject> validCC = s -> s.enterCardDetails("4111111111111111", "2023", "123");
    //    Buy
    public static Consumer<PaymentScreenPageObject> Buy = s -> s.buynow();
    //    Validations
    public static Consumer<PaymentScreenPageObject> successfulPurchase = s -> Assert.assertEquals(s.verifyStatus(), "PASS");
    public static Consumer<PaymentScreenPageObject> failedPurchase = s -> Assert.assertEquals(s.verifyStatus(), "FAIL");
}
