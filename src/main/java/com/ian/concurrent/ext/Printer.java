package com.ian.concurrent.ext;

public class Printer {
    private final int[] numbers = new int[52];
    private final char[] chars = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
            'Q','R','S','T','U','V','W','X','Y','Z'};
    private int i = 0;
    private boolean flag = false;

    public Printer(){
        for (int i = 0; i < 52; i++) {
            numbers[i] = i + 1;
        }
    }

    public synchronized boolean printNumber(int i){
        boolean result = false;
        try{
            if (flag){
                wait();
            }else{
                System.out.print(numbers[i]);
                System.out.print(numbers[i+1]);
                flag = true;
                notifyAll();
                result = true;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public synchronized boolean printChar(int i){
        boolean result = false;
        try{
            if(!flag){
                wait();
            }else{
                System.out.print(chars[i]);
                flag = false;
                notifyAll();
                result = true;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
