package com.ian.concurrent.ext.exercise2;

public class ParkingArea {

    private boolean[] parks = {false, false, false};

    public boolean hasPos(){
        boolean result = false;
        for (int i = 0; i < parks.length; i++) {
            if (!parks[i]){
                result = true;
                break;
            }
        }
        return result;
    }

    public int parking(){
        int result = -1;
        for (int i = 0; i < parks.length; i++) {
            if (!parks[i]){
                parks[i] = true;
                result = i;
                break;
            }
        }
        return result;
    }

    public void leaving(){
        for (int i = 0; i < parks.length; i++) {
            if (parks[i]){
                parks[i] = false;
                break;
            }
        }
    }
}
