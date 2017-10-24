package com.ian.concurrent.forkjointhread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForkJoinPoolTest {

    public static void main(String[] args) throws Exception{

        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new PrintTask(0,300));
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();
    }
}
