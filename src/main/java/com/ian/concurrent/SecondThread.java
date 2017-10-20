package com.ian.concurrent;

public class SecondThread implements Runnable {

    private int i;
    @Override
    public void run() {
        for(; i < 100; i++){
            // 当线程类实现Runnable接口时
            // 如果想获得当前线程，只能使用Thread.currentThread()方法
            System.out.println(Thread.currentThread().getName() + "=>" + i);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "->" + i);
            if (i == 20){
                SecondThread st = new SecondThread();
                // 通过new Thread(target, name)方法创建新线程
                // 多个线程共享一个target，所以这里target里的实例变量是可以在线程间共享的
                new Thread(st, "新线程1").start();
                new Thread(st, "新线程2").start();
                // 因为Runnable接口也用@FunctionalInterface修饰，所以可以使用Lambda表达式，
                new Thread(()-> {
                    for (int j = 0; j < 100; j++) {
                        System.out.println(Thread.currentThread().getName() + "=>" + j);
                    }
                }, "新线程3").start();
            }
        }
    }
}
