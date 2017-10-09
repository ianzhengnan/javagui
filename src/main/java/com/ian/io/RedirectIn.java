package com.ian.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class RedirectIn {

    public static void main(String[] args) throws IOException{

        try (
                FileInputStream fileInputStream = new FileInputStream("src/main/java/com/ian/io/RedirectIn.java")
        ) {
            System.setIn(fileInputStream);
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            while(scanner.hasNext()){
                System.out.println("键盘输入的内容是：" + scanner.next());
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
