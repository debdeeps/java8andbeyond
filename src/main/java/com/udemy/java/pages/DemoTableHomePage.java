package com.udemy.java.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Predicate;
public class DemoTableHomePage {
    private final WebDriver driver;
    public DemoTableHomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
    }
    public void selectCheckBoxes(Predicate<List<WebElement>> gender) {
        List<WebElement> elements = this.driver.findElements(By.tagName("tr"));
        elements.stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td")))
                .filter(gender)
                .map(s -> s.get(3).findElement(By.tagName("input")))
                .forEach(s -> s.click());
    }
}
