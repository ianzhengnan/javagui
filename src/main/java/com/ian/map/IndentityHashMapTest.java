package com.ian.map;

import java.util.IdentityHashMap;

public class IndentityHashMapTest {

    public static void main(String[] args) {

        IdentityHashMap ihm = new IdentityHashMap();
        ihm.put(new String("语文"), 89);
        ihm.put(new String("语文"), 90);

        ihm.put("java", 100);
        ihm.put("java", 88);

        System.out.println(ihm); // {语文=90, 语文=89, java=88}
        System.out.println((new String("语文") == (new String("语文")))); // false
        System.out.println("java" == "java"); // true
    }
}
