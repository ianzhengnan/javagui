package com.ian.concurrent.ext;

public class PrintNumber implements Runnable {

    private Printer printer;

    public PrintNumber(Printer printer){
        this.printer = printer;
    }

    @Override
    public void run() {
        int i = 0;
        while(i < 52){
            if (printer.printNumber(i)){
                i += 2;
            }
        }
    }
}
