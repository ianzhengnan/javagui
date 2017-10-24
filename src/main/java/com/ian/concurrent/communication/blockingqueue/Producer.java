package com.ian.concurrent.communication.blockingqueue;

import java.util.concurrent.BlockingQueue;

class Producer extends Thread{
    private BlockingQueue<String> bq;
    public Producer(BlockingQueue<String> bg){
        this.bq = bg;
    }
    public void run(){
        String[] strArr = new String[]{
                "Java",
                "Struts",
                "Spring"
        };
        for (int i = 0; i < 999999999; i++) {
//            System.out.println(getName() + "生产者准备生产集合元素！");
            try{
                Thread.sleep(200);
                bq.put(strArr[i % 3]);
                System.out.println("生成者" + getName() + "生产了：" + strArr[i % 3]);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(getName() + "生产完成：" + bq);
        }
    }
}
