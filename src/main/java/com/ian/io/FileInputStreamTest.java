package com.ian.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {

    private static File file;
    private static FileInputStream inputStream;

    public static void main(String[] args) throws IOException{
        try{
                // test.txt必须放在项目的根目录, 这里的中文会变成乱码
//                file = new File("test.txt");
                file = new File("src/main/java/com/ian/io/FileInputStreamTest.java");
                inputStream = new FileInputStream(file);
                // 也可以而是用下面的构造方法
//                inputStream = new FileInputStream("FileInputStreamTest.java");
                // 每次读取20字节的数据
                byte[] bytes = new byte[20];
                // hasRead返回每次读取的字节数
                int hasReads;
                // 返回-1代表到了文件的结尾
                while ((hasReads = inputStream.read(bytes)) > 0){
                    System.out.print(new String(bytes,0,hasReads));
                }
        }catch (IOException ioe){
            ioe.printStackTrace();
            System.out.println("Cannot find specific file!");
        }finally {
            inputStream.close();
        }

    }
}
