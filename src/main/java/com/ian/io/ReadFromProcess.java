package com.ian.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromProcess {

    public static void main(String[] args) throws IOException{

        Process process = Runtime.getRuntime().exec("javac");
        try (
                // 字符流的处理流
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))
        ) {
            String buff;
            while((buff = bufferedReader.readLine()) != null){
                System.out.println(buff);
            }
        }
    }
}
