package com.udemy.java.stream;
import java.util.ArrayList;
import java.util.List;

public class WithoutStream {
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
        int count=0;
        for (int i = 0; i < 9; i++) {
            if (list.get(i)%2==0 && count <3){
                System.out.println(list.get(i)*list.get(i));
                count++;
            }
        }

    }
}
