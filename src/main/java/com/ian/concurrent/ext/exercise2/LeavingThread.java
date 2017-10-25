package com.ian.concurrent.ext.exercise2;

public class LeavingThread extends Thread {

    private ParkingArea pa;

    public LeavingThread(String name, ParkingArea pa){
        super(name);
        this.pa = pa;
    }

    public void run(){

        synchronized (pa){
            pa.leaving();
            System.out.println(getName() + "正在离开车位");
        }
    }
}
