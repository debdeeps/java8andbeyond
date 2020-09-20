package com.udemy.java.stream.compare;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;
public class StudentMain {
    public static void main(String[] args) {
        Student ram = new Student("Ram", 67, 135);
        Student vinita = new Student("Vinita", 78, 115);
        Student jadu = new Student("Jadu", 60, 105);
        Optional<Student> maxScore = Stream.of(ram, vinita, jadu)
                .min(Comparator.comparing(s -> s.getName()));
        if (maxScore.isPresent())
            System.out.println(maxScore.get());
        else
            System.out.println("Record does not exist.");
    }
}
