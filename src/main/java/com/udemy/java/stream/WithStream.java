package com.udemy.java.stream;
import java.util.ArrayList;
import java.util.List;
public class WithStream {
    public static final List<Integer> list = new ArrayList<>();
    static {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
    }
    public static void main(String[] args) {
        list.stream().filter(i->i%2==0).filter(i->i>5).limit(3).map(i->i*i+2).forEach(System.out::println);
    }
}
