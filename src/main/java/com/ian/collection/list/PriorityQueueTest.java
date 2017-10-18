package com.ian.collection.list;

import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {

        PriorityQueue pq = new PriorityQueue();
        pq.offer(6);
        pq.offer(-1);
        pq.offer(10);
        pq.offer(8);
        System.out.println(pq); // -1, 6, 10, 8
        System.out.println(pq.poll());
        System.out.println(pq);
    }
}
