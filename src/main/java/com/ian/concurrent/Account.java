package com.ian.concurrent;

public class Account {

    private String accountNo;
    private double balance;

    public Account(String accountNo, double balance){
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int hashCode(){
        return accountNo.hashCode();
    }

    public boolean equals(Object obj){
        // == 表示严格相等
        if (this == obj){
            return true;
        }
        if (obj != null && obj.getClass() == Account.class){
            Account target = (Account)obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }
    // 同步方法，该方法的同步监听器是this
    public synchronized void draw(double drawAmount){
        if(balance >= drawAmount){
            System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票：" + drawAmount);
            try{
                Thread.sleep(1);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
            balance -= drawAmount;
            System.out.println("\t余额为：" + balance);
        }else{
            System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足！");
        }
    }
}
