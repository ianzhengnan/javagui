package com.ian.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class FileInputStreamTest {

    private static File file;
    private static FileInputStream inputStream;
    private static PushbackInputStream pushbackInputStream;

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

                // 跳过40字节
//                inputStream.skip(40);
                // 当前不支持
                if (inputStream.markSupported()){
                    inputStream.mark(50);
                }

                // 其他read方法, 从缓冲区中读取从len(10)个字节，放到bytes数组中，不过不是从头放，是从offset的位置开始,所以，读取的后三位没有打印出来
//                int tmp = inputStream.read(bytes, 3, 10);
//                System.out.println(new String(bytes, 0, tmp));

                // 退回缓冲区
//                pushbackInputStream = new PushbackInputStream(inputStream, 100);



                // 返回-1代表到了文件的结尾
                while ((hasReads = inputStream.read(bytes)) > 0){
                    System.out.print(new String(bytes,0,hasReads));
                    if(inputStream.markSupported()){
                        inputStream.reset(); // reset到mark位置
                    }
                }
        }catch (IOException ioe){
            ioe.printStackTrace();
            System.out.println("Cannot find specific file!");
        }finally {
            inputStream.close();
        }

    }
}
