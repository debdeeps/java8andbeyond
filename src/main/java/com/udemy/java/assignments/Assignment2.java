package com.udemy.java.assignments;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
public class Assignment2 {
    public static void main(String[] args) throws IOException {
        //D:\EXCEPT OS\Eclipse\Java8 and beyond\first-names.txt
        Path path = Paths.get("D:\\EXCEPT OS\\Eclipse\\Java8 and beyond\\first-names.txt");
        List<String> list = Files.readAllLines(path);
        List<String> collect = list.stream()
                .filter(s -> s.contains("-"))
                .map(s -> s.replaceAll("-", " "))
                .collect(Collectors.toList());
        System.out.println(collect.size());
        System.out.println(
                list.stream()
                        .max(Comparator.comparing(s -> s.length()))
                        .get()
        );
    }
}
