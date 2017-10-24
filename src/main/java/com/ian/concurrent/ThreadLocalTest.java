package com.ian.concurrent;

public class ThreadLocalTest {

    class Account{
        private ThreadLocal<String> name = new ThreadLocal<>();

        public Account(String str){
            this.name.set(str);
        }

        public void setName(String str){
            this.name.set(str);
        }

        public String getName(){
            return this.name.get();
        }

    }

    class MyTest extends Thread{

        private Account account;
        public MyTest(String name, Account account){
            super(name);
            this.account = account;
        }
        public void run(){
            for (int i = 0; i < 10; i++) {
                // 当i == 6时输出将账户名替换成当前线程名
                if(i == 6){
                    account.setName(getName());
                }
                System.out.println(account.getName() + " 账户的i值：" + i);
            }
        }
    }

    public void init(){
        Account acc = new Account("初始名");
        new MyTest("线程甲", acc).start();
        new MyTest("线程乙", acc).start();
    }

    public static void main(String[] args) throws Exception{
        new ThreadLocalTest().init();
    }

}
