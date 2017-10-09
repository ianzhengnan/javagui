package com.ian.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class WriteToProcess {

    public static void main(String[] args) throws IOException{

        Process process = Runtime.getRuntime().exec("java ReadStandard");
        try (
                PrintStream printStream = new PrintStream(process.getOutputStream())
        ) {
            printStream.println("普通字符串");
            printStream.println(new WriteToProcess());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class ReadStandard{

    public static void main(String[] args) throws IOException{
        try (
                Scanner sc = new Scanner(System.in);
                PrintStream printStream = new PrintStream(new FileOutputStream("src/main/java/com/ian/io/WriteToProcess.tmp"))
        ) {
            sc.useDelimiter("\n");
            while(sc.hasNext()){
                printStream.println("键盘输入的内容是：" + sc.next());
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
