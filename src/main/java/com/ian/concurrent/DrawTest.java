package com.ian.concurrent;

public class DrawTest {

    public static void main(String[] args) {

        Account account = new Account("1234567", 1000);
        new DrawThread("甲", account, 800).start();
        new DrawThread("乙", account, 100).start();
        new DrawThread("丙", account, 300).start();
    }
}
