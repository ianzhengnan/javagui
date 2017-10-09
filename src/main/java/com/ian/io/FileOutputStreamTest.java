package com.ian.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

    public static void main(String[] args) throws IOException {

        try(
                FileInputStream inputStream = new FileInputStream("src/main/java/com/ian/io/FileOutputStreamTest.java");
                FileOutputStream outputStream = new FileOutputStream("src/main/java/com/ian/io/FileOutputStreamTest.tmp")
                ){
            byte[] bytes = new byte[20];
            int hasRead;
            while((hasRead = inputStream.read(bytes)) > 0){
                // 每次写入bytes数组中的0~19 共20个字节
                outputStream.write(bytes, 0, hasRead);
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
