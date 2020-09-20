package com.udemy.java.test;
import com.udemy.java.pages.DemoTableHomePage;
import com.udemy.java.supplier.DriverFactory;
import com.udemy.java.supplier.SearchCriteriaFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.util.List;
import java.util.function.Predicate;
public class HoverableDropDownTest {
    private WebDriver driver;
    private DemoTableHomePage demoTableHomePage;
    private SearchCriteriaFactory searchCriteriaFactory;
    private Actions act;
    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);

        act=new Actions(this.driver);
    }
    @Test(dataProvider = "linkprovider")
    public void googleTest(String path) {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/drop-down.html");
//        demoTableHomePage.goTo();
        String[] strPath = path.split("=>");
        WebElement source=driver.findElement(By.linkText(strPath[0]));
//        WebElement source=driver.findElement(By.cssSelector("a.dropdown-toggle"));
        act.moveToElement(source);


    }
    @DataProvider(name = "linkprovider")
    public Object[] getData() {
//        Predicate<List<WebElement>> allMale = s -> s.get(1).getText().equalsIgnoreCase("Male");
//        Predicate<List<WebElement>> allFemale = s -> s.get(1).getText().equalsIgnoreCase("Female");
//        Predicate<List<WebElement>> allGender = allMale.or(allFemale);
        return new Object[]{
                "Dropdown => Dropdown Link 2",
                "Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.1",
                "Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.4 => Dropdown Submenu Link 5.4.2"
        };
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
