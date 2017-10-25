package com.ian.concurrent.ext.exercise2;

public class ParkingTest2 {

    public static void main(String[] args) {

        ParkingArea pa = new ParkingArea();

        new ParkingThread("flks", pa).start();
        new ParkingThread("kaka", pa).start();
        new ParkingThread("Ian", pa).start();
        new ParkingThread("John", pa).start();
        new LeavingThread("flks", pa).start();
        new LeavingThread("kaka", pa).start();
        new LeavingThread("Ian", pa).start();
        new LeavingThread("John", pa).start();

    }
}
