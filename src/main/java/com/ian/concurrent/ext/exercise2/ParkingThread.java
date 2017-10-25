package com.ian.concurrent.ext.exercise2;

public class ParkingThread extends Thread {

    private ParkingArea pa;

    public ParkingThread(String name,ParkingArea pa){
        super(name);
        this.pa = pa;
    }

    public void run(){

        synchronized (pa){
            if(pa.hasPos()){
                System.out.println(getName() + "正在把车停在" + pa.parking() + "号车位");
            }else{
                System.out.println("车位已满，" + getName() + "无处可停");
            }
        }
    }
}
