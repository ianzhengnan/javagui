package com.ian.concurrent.communication;

import java.util.concurrent.BlockingQueue;

class Consumer extends Thread{
    private BlockingQueue<String> bq;

    public Consumer(BlockingQueue<String> bq) {
        this.bq = bq;
    }
    public void run(){
        while(true){
//            System.out.println(getName() + "消费者准备消费集合元素！");
            try{
                Thread.sleep(200);
                System.out.println("消费者" + getName() + "消费了：" + bq.take());
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(getName() + "消费完成：" + bq);
        }
    }
}
