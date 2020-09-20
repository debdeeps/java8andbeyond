package com.udemy.java.test;
import com.udemy.java.supplier.DriverFactory;
import com.udemy.java.supplier.rules.Rules;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.function.Predicate;
public class DriverTest {
    private WebDriver driver;
    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test (dataProvider = "data")

    public void googleTest(String gender) {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
        List<WebElement> elements = this.driver.findElements(By.tagName("tr"));
        elements.stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td")))
                .filter(s -> s.get(1).getText().equalsIgnoreCase(gender))
                .map(s -> s.get(3).findElement(By.tagName("input")))
                .forEach(s -> s.click());
    }
    @DataProvider(name = "data")
    public Object[] getData() {
        return new Object[]{"Male", "Female"};
    }
        /*System.out.println("Before::" + elements.size());
        elements.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .filter(s -> s.length() > 0)
                .filter(s -> !s.toLowerCase().contains("s"))
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);*/
//        Rules.get().forEach(elements::removeIf);
//        Predicate<WebElement> isBlank = s -> s.getText().trim().length() == 0;
//        Predicate<WebElement> hasS = s -> s.getText().toLowerCase().contains("s");
//                .forEach(s->System.out.println(s.getText()));
//        elements.removeIf(isBlank.or(hasS));
        /*System.out.println("After::" + elements.size());
        elements.forEach(s -> System.out.println(s.getText()));*/

    @AfterTest
    public void closeBrowser() {
        this.driver.quit();
    }
}
