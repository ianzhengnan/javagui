package com.ian.concurrent.ext.exercise2;

import java.util.concurrent.BlockingQueue;

public class Leaving implements Runnable {

    private BlockingQueue<String> bq;

    public Leaving(BlockingQueue<String> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
            System.out.println(bq.take() + "正在离开。。。");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
