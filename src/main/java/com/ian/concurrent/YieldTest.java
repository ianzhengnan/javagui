package com.ian.concurrent;

public class YieldTest extends Thread{

    public YieldTest(String name){
        super(name);
    }

    public void run(){
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + "=>" + i);
            if(i == 20){
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        // 启动两个线程
        YieldTest yt1 = new YieldTest("高级");
        yt1.setPriority(Thread.MAX_PRIORITY);
        yt1.start();
        YieldTest yt2 = new YieldTest("低级");
        // 这里设置了低级别，当高级别被yield暂停后，低级别得不到执行，高级别继续执行。全部执行完后，才执行低级别
        yt2.setPriority(Thread.MIN_PRIORITY);
        yt2.start();
    }
}
