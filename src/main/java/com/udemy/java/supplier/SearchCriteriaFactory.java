package com.udemy.java.supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
public class SearchCriteriaFactory {
    private static Predicate<List<WebElement>> allMale = s -> s.get(1).getText().equalsIgnoreCase("Male");
    private static Predicate<List<WebElement>> allFemale = s -> s.get(1).getText().equalsIgnoreCase("Female");
    private static Predicate<List<WebElement>> allGender = allMale.or(allFemale);
    private static final Map<String, Predicate<List<WebElement>>> MAP = new HashMap<>();
    static {
        MAP.put("allMale", allMale);
        MAP.put("allFemale", allFemale);
        MAP.put("allGender", allGender);
    }
    public static Predicate<List<WebElement>> getCriteria(String criteria) {
        return MAP.get(criteria);
    }
}
