package com.udemy.java.assignments;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
public class FirstNames {
    public static void main(String[] args) throws IOException {
        //D:\EXCEPT OS\Eclipse\Java8 and beyond\first-names.txt
        Path path = Paths.get("D:\\EXCEPT OS\\Eclipse\\Java8 and beyond\\first-names.txt");
        List<String> list = Files.readAllLines(path);
        System.out.println(
                list.stream()
                        .filter(s -> s.startsWith("B"))
                        .count()
        );
        List<String> ll = list.stream()
                .filter(s -> s.startsWith("C") && s.contains("s"))
                .collect(Collectors.toList());
//        System.out.println(ll);
        System.out.println(ll.size());
        System.out.println(
                list.stream()
                        .filter(s -> s.startsWith("M"))
                        .map(s -> s.length())
                        .mapToInt(s -> s)
                        .sum()
        );
    }
}
