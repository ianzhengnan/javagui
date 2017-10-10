package com.ian.io.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ReadFile {

    public static void main(String[] args) throws IOException{
        try (
                // 创建FileInputStream对象
                FileInputStream fileInputStream = new FileInputStream("src/main/java/com/ian/io/nio/ReadFile.java");
                // 创建FileChannel
                FileChannel fileChannel = fileInputStream.getChannel()
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(256);
            // 每次读取256个字节的数据到buffer
            while(fileChannel.read(buffer) != -1){
                // 锁定空白区域，如果文件的长度小于256的话
                buffer.flip();
                Charset charset = Charset.forName("UTF-8");
                CharsetDecoder decoder = charset.newDecoder();
                // 转换ByteBuff为CharBuffer
                CharBuffer cbuff = decoder.decode(buffer);
                System.out.println(cbuff);
                // 将Buffer内的位置元素初始化，为下一次读取做准备
                buffer.clear();
            }
        }
    }
}
