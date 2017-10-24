package com.ian.concurrent.communication.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    // 显示定义Lock对象
    private final Lock lock = new ReentrantLock();
    // 获得指定Lock对象对应的Condition
    private final Condition cond = lock.newCondition();
    private String accountNo;
    private double balance;
    private boolean flag = false;

    public Account(){

    }

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

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int hashCode(){
        return accountNo.hashCode();
    }

    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if(obj != null && obj.getClass() == Account.class){
            Account target = (Account)obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }

    public void draw(double drawAmount){
        lock.lock();
        try{
            if(!flag){
                cond.await();
            }else{
                System.out.println(Thread.currentThread().getName() + " 取钱：" + drawAmount);
                balance -= drawAmount;
                System.out.println("账户余额为：" + balance);
                flag = false;
                cond.signalAll();
            }
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void deposit(double depositAmount){
        lock.lock();
        try{
            if (flag){
                cond.await();
            }else{
                System.out.println(Thread.currentThread().getName() + " 存款为："  + depositAmount);
                balance += depositAmount;
                System.out.println("账户余额为：" + balance);
                flag = true;
                cond.signalAll();
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
