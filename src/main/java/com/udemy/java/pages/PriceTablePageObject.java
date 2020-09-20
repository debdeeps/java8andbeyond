package com.udemy.java.pages;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
public class PriceTablePageObject {
    private final WebDriver driver;
    @FindBy(css = "table#prods tr")
    private List<WebElement> rows;
    @FindBy(css = "input#result")
    private WebElement button;
    @FindBy(id = "status")
    private WebElement statustxt;
    public PriceTablePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-price.html");
    }
    public void selectRadioButton() {
        Optional<List<WebElement>> minRow = rows.stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td")))
                .min(Comparator.comparing(s -> Integer.parseInt(s.get(2).getText())));
        System.out.println(minRow);
        if (minRow.isPresent()) {
            List<WebElement> cells = minRow.get();
            cells.get(3).findElement(By.cssSelector("input.radio")).click();
        } else {
            System.out.println("Element not present");
        }
//        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
        button.click();
//        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
    }
    public String getStatus() {
        return statustxt.getText().trim();
    }
}
