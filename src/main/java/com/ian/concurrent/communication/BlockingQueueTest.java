package com.ian.concurrent.communication;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

    public static void main(String[] args) {
        // 创建一个容量为1的BlockingQueue
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(4);
        // 启动3个生产者线程
        new Producer(bq).start();
        new Producer(bq).start();
        new Producer(bq).start();
        // 启动一个消费者线程
        new Consumer(bq).start();
    }
}
