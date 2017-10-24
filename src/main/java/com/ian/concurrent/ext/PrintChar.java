package com.ian.concurrent.ext;

public class PrintChar implements Runnable {

    private Printer printer;

    public PrintChar(Printer printer){
        this.printer = printer;
    }

    @Override
    public void run() {
        int i = 0;
        while(i < 26){
            if (printer.printChar(i)){
                i++;
            }
        }
    }
}
