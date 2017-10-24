package com.ian.concurrent.ext.exercise2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ParkingTest {

    public static void main(String[] args) {

        // 创建一个容量为3的BlockingQueue
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(3);
        new Thread(new Parking(bq), "甲").start();
        new Thread(new Parking(bq), "乙").start();
        new Thread(new Parking(bq), "丙").start();
        new Thread(new Parking(bq), "丁").start();
        new Thread(new Leaving(bq), "甲").start();
        new Thread(new Leaving(bq), "乙").start();
        new Thread(new Leaving(bq), "丙").start();
    }
}
