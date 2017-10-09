package com.ian.io;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

    public static void main(String[] args) throws IOException{

        try(
                // 读取字节流, 构造器跟FileInputStream相同，可以接受String, File, FileDescriptor
                FileReader fileReader = new FileReader("src/main/java/com/ian/io/FileReaderTest.java")
                ){
            // 创建字节流缓冲
            char[] chars = new char[1024];
            int hasRead;
            // hasRead返回每次读取的字符数
            while((hasRead = fileReader.read(chars)) > 0){
                // 创建一个char数组的字符串, 依次打印下去
                System.out.print(new String(chars,0,hasRead));
            }
        }
    }
}
