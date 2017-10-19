package com.ian.map;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {

    public static void main(String[] args) {

        LinkedHashMap scores = new LinkedHashMap();
        scores.put("语文", 90);
        scores.put("数学", 98);
        scores.put("英语", 100);
        scores.forEach((key, value) -> System.out.println(key + "-->" + value));

    }
}
