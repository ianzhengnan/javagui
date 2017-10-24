package com.ian.concurrent.ext.exercise2;

import java.util.concurrent.BlockingQueue;

public class Parking implements Runnable {

    private BlockingQueue<String> bq;

    public Parking(BlockingQueue<String> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
            if (bq.remainingCapacity() == 0){
                System.out.println("车位已停满，" + Thread.currentThread().getName() + "无法停车");
            }else{
                bq.put(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName() + "正在停车。。。");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
