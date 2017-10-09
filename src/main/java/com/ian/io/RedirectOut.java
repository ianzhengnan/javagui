package com.ian.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class RedirectOut {

    public static void main(String[] args) throws IOException{

        try (
                PrintStream printStream = new PrintStream(new FileOutputStream("src/main/java/com/ian/io/RedirectOut.tmp"))
        ) {
            System.setOut(printStream);
            // 此处会有乱码，文件格式为什么是ASCII?
            System.out.println("你好啊，祖国");
            System.out.println(new RedirectOut());
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
