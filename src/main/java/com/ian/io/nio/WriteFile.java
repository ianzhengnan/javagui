package com.ian.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteFile {

    public static void main(String[] args) throws IOException{

        try (
                FileInputStream fileInputStream = new FileInputStream("src/main/java/com/ian/io/nio/WriteFile.java");
                FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/com/ian/io/nio/WriteFile.tmp");
                FileChannel inChannel = fileInputStream.getChannel();
                FileChannel outChannel = fileOutputStream.getChannel()
        ) {
            // 分配一个“竹筒” 或者 “块” 用来分批装数据
            ByteBuffer bbuff = ByteBuffer.allocate(256);
            while(inChannel.read(bbuff) != -1){
                // 锁定空白区域, 为了下一步输出
                bbuff.flip();
                outChannel.write(bbuff);
                // 重置位置信息，为了下一次读取
                bbuff.clear();
            }
        }
    }
}
