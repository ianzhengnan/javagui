package com.ian.concurrent;

public class ExHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getName() + " 线程出现了异常: " + e.getMessage());
    }

    public static void main(String[] args) {
        // 为主线程设置默认的Uncaught Exception handler
        Thread.currentThread().setUncaughtExceptionHandler(new ExHandler());
        int a = 3 / 0;
        System.out.println("程序正常结束！");
    }
}
