package com.ian.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionTest {

    public static void main(String[] args) {

        Collection c = new ArrayList();
        c.add("曹操");
        c.add(2);
        System.out.println("c集合的元素个数为：" + c.size());

        c.remove(2);
        System.out.println("c集合的元素个数为：" + c.size());

        System.out.println("c集合是否包含\"曹操\"字符串？" + c.contains("曹操"));

        c.add("王阳明心学");
        System.out.println("c集合的元素：" + c);

        Collection books = new HashSet();
        books.add("岛上书店");
        books.add("黑天鹅");
        books.add("王阳明心学");

        books.forEach(obj -> System.out.println("迭代集合元素：" + obj));

        System.out.println("c集合是否完全包含books集合？" + c.containsAll(books));

        c.removeAll(books);
        System.out.println("c集合里的元素：" + c);

        c.clear();
        System.out.println("c集合里的元素：" + c);

        books.retainAll(c);
        System.out.println("books集合的元素：" + books);

    }
}
