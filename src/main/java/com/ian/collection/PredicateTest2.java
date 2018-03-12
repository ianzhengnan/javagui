package com.ian.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

public class PredicateTest2 {
	
    public static void main(String[] args) {

        Collection books = new HashSet();
        books.add(new String("轻量级javaee开发"));
        books.add(new String("疯狂java讲义"));
        books.add(new String("疯狂ios讲义"));

        System.out.println(calAll(books, ele -> ((String)ele).contains("疯狂")));
        System.out.println(calAll(books, ele -> ((String)ele).contains("java")));
        System.out.println(calAll(books, ele -> ((String)ele).length() > 10));
    }

    private static int calAll(Collection books, Predicate p){
        int total = 0;
        for (Object obj :
                books) {
            if (p.test(obj)) {
                total++;
            }
        }
        return total;
    }
}
