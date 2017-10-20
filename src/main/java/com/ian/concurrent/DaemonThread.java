package com.ian.concurrent;

public class DaemonThread extends Thread{

    public void run(){
        for (int i = 0; i < 1000; i++) {
            System.out.println(getName() + "=>" + i);
        }
    }

    public static void main(String[] args) {

        DaemonThread dt = new DaemonThread();
        dt.setDaemon(true);
        System.out.println("dt线程是后台线程吗？" + dt.isDaemon());
        dt.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "->" + i);
        }

        // 程序执行到这里结束，前台线程（main线程）结束-----
        // 后台线程也随之结束
    }
}
