package com.ian.collection.list;

import java.util.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {

        LinkedList movies = new LinkedList();
        movies.offer("廊桥遗梦");
        movies.push("星球大战");
        movies.offerLast("星际传奇");
        System.out.println(movies);

        for (int i = 0; i < movies.size(); i++) {
            System.out.println("遍历中：" + movies.get(i));
        }
        System.out.println(movies.peekFirst());
        System.out.println(movies.peekLast());
        System.out.println(movies.pop());
        System.out.println(movies);
        System.out.println(movies.pollLast());
        System.out.println(movies);
    }
}
