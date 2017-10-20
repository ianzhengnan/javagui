package com.ian.concurrent;

public class FirstThread extends Thread{

    private int i;

    public void run(){
        for (; i < 100; i++) {
            // Thread对象的getName()方法返回当前线程的名字
            // 直接使用this即可获得当前线程
            System.out.println(getName() + "=>" + i);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "->" + i);
            if(i == 20){
                new FirstThread().start(); // Thread-0
                new FirstThread().start(); // Thread-1
            }
        }
    }
}
