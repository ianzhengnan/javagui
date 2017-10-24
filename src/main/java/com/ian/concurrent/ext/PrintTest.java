package com.ian.concurrent.ext;

public class PrintTest {

    public static void main(String[] args) {

        Printer printer = new Printer();
        new Thread(new PrintNumber(printer), "打印数字").start();
        new Thread(new PrintChar(printer), "打印字符").start();

    }
}
