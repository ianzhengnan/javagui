package com.ian.library;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RuntimeTest {

    public static void main(String[] args) throws IOException{
        Runtime rt = Runtime.getRuntime();
        long base = 1024 * 1024;
        System.out.println("处理器数量：" + rt.availableProcessors());
        System.out.println("内存空闲数：" + rt.freeMemory());
        System.out.println("总内存数：" + rt.totalMemory());
        System.out.println("可用最大内存数：" + rt.maxMemory());
        // 开始一个新进程，打开记事本程序
        rt.exec("notepad.exe");
        Object obj = new Object();

        Properties props = new Properties();
        props.load(new FileInputStream("kak.txt"));
    }
}
