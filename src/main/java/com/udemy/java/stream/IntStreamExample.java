package com.udemy.java.stream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class IntStreamExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int total = list.stream()
                .mapToInt(a -> a)
                .sum();
        System.out.println(total);
    }
}
