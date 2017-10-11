package com.ian.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {

    public static void main(String[] args) throws IOException{

        try (
                FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/com/ian/io/PrintStreamTest.tmp");
                // PrintStream字节输出流，是一个处理流。 PrintWriter是一个字符输出流，也是一个处理流
                PrintStream printStream = new PrintStream(fileOutputStream)
        ) {
            printStream.println("普通字符串");
            printStream.println(new PrintStreamTest());
        }
    }
}
