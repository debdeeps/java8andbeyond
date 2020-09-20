package com.udemy.java.supplier.rules;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
public class Rules {
    public static Predicate<WebElement> isBlank = s -> s.getText().trim().length() == 0;
    public static Predicate<WebElement> hasS = s -> s.getText().toLowerCase().contains("s");
    public static List<Predicate<WebElement>> get(){
        List<Predicate<WebElement>> list = new ArrayList<>();
                list.add(isBlank);
                list.add(hasS);

        return list;

    }

}
