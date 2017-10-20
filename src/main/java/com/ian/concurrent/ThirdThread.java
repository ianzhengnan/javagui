package com.ian.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThirdThread implements Callable{

    public static void main(String[] args) {

        ThirdThread rt = new ThirdThread();
        // 使用Lambda创建Callable<Integer>对象
        // 使用FutureTask包装Callable对象
//        FutureTask<Integer> task = new FutureTask<Integer>(rt);
        FutureTask<Integer> task = new FutureTask<>((Callable<Integer>)() -> {
            int i = 0;
            for(; i < 100 ; i++){
                System.out.println(Thread.currentThread().getName() + "=>" + i);
            }
            // call()方法的返回值
            return i;
        });
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "->" + i);
            if (i == 20){
                new Thread(task, "有返回值的线程").start();
            }
        }

        try{
            System.out.println("子线程的返回值：" + task.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Object call() throws Exception {
        int i = 0;
        for(; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + "=>" + i);
        }
        // 返回值
        return i;
    }
}
