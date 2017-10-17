package com.ian.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorTest {

    public static void main(String[] args) {

        Collection books = new HashSet();
        books.add("王阳明心学");
        books.add("疯狂java讲义");
        books.add("轻量级javaee编程");

        Iterator iterator = books.iterator();
        while (iterator.hasNext()){
            String book = (String)iterator.next();
            System.out.println(book);
            if(book.equals("疯狂java讲义")){
                iterator.remove(); // 工作正常
            }
            // 这里会立即抛出异常，因为在迭代的时候必能修改集合元素
//            books.add("哈哈哈哈");
//            books.remove(book);
        }

        System.out.println("==============================");
        books.forEach(obj -> System.out.println(obj));

        // java8给Iterator新增迭代方法
        Collection tools = new HashSet();
        tools.add("java");
        tools.add("python");
        tools.add("ruby");
        Iterator it = tools.iterator();
        System.out.println("==============================");
        it.forEachRemaining(obj -> System.out.println("迭代集合元素：" + obj));
    }
}
