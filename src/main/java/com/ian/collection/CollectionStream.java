package com.ian.collection;

import java.util.Collection;
import java.util.HashSet;

public class CollectionStream {

    public static void main(String[] args) {

        Collection books = new HashSet();
        books.add(new String("轻量级javaee开发"));
        books.add(new String("疯狂java讲义"));
        books.add(new String("疯狂ios讲义"));

        System.out.println(books.stream().filter(ele -> ((String)ele).contains("疯狂")).count());
        System.out.println(books.stream().filter(ele -> ((String)ele).contains("java")).count());
        System.out.println(books.stream().filter(ele -> ((String)ele).length() > 10).count());

        // 先调用Collection对象的stream()方法将集合转换成Stream
        // 再调用stream的mapToInt()方法获取原有的Stream对应的IntStream
        books.stream().mapToInt(ele -> ((String)ele).length()).forEach(System.out::print);
    }


}
