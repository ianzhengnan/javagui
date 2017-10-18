package com.ian.collection.list;

import java.util.ArrayDeque;

public class ArrayDequeTest {

    public static void main(String[] args) {

        ArrayDeque stack = new ArrayDeque();

        stack.push("廊桥遗梦");
        stack.push("星际传奇");
        stack.push("星球大战");

        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);

        ArrayDeque queue = new ArrayDeque();
        queue.offer("廊桥一梦");
        queue.offer("星球大战");
        queue.offer("星际传奇");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
