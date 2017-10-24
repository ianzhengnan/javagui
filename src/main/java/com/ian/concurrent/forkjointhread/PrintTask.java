package com.ian.concurrent.forkjointhread;

import java.util.concurrent.RecursiveAction;

public class PrintTask extends RecursiveAction {

    private static final int THRESHOLD = 50;
    private int start;
    private int end;

    public PrintTask(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start < THRESHOLD){
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + "的i值：" + i);
            }
        }else{
            // 当end与start之间的差大于THHRESHOLD，将大任务分解为两个小任务
            int middle = (start + end) / 2;
            PrintTask left = new PrintTask(start, middle);
            PrintTask right = new PrintTask(middle, end);
            // 并行执行两个”小程序“
            left.fork();
            right.fork();
        }
    }
}
