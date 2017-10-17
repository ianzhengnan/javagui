package com.ian.collection;

import java.util.Collection;
import java.util.HashSet;

public class PredicateTest {

    public static void main(String[] args) {

        Collection books = new HashSet();
        books.add(new String("轻量级javaee开发"));
        books.add(new String("疯狂java讲义"));
        books.add(new String("疯狂ios讲义"));

        // 使用Lambda表达式，去除包含“疯狂”的书
        books.removeIf(ele -> ((String) ele).contains("疯狂"));
        System.out.println(books);
    }
}
