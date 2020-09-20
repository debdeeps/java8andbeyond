package com.udemy.java.stream;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Optional<Integer> sum = list.stream()
                .reduce((a, b) -> a + b);
        if (sum.isPresent())
            System.out.println("Sum=" + sum.get());
        else
            System.out.println("No element found.");
    }
}
