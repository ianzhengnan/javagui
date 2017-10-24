package com.ian.concurrent.communication.condition;

public class DrawTest {

    public static void main(String[] args) {

        Account account = new Account("1234567", 0);
        new DrawThread("取钱者", account, 800).start();
        new DepositThread("存钱者甲", account, 800).start();
        new DepositThread("存钱者乙", account, 800).start();
        new DepositThread("存钱者丙", account, 800).start();
    }
}
