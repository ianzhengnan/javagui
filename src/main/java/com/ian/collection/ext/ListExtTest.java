package com.ian.collection.ext;

import java.util.ArrayList;
import java.util.List;

public class ListExtTest {

    public static void main(String[] args) {

        List<Integer> ints = new ArrayList<>();
        ints.add(10);
        ints.add(5);
        ints.add(6);
        ints.add(8);
        ints.add(35);
        ints.add(56);
        System.out.println(ints.get(5));

        System.out.println("The index of 10 is " + ints.indexOf(10));
        System.out.println("The index of 8 is " + ints.indexOf(8));

        ints.remove(3);
        System.out.println(ints);
    }
}
