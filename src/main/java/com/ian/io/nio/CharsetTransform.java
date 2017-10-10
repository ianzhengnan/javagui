package com.ian.io.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetTransform {

    public static void main(String[] args) throws Exception{

        Charset charset = Charset.forName("UTF-8");
        CharsetDecoder decoder = charset.newDecoder();
        CharsetEncoder encoder = charset.newEncoder();

        CharBuffer cbuff = CharBuffer.allocate(8);
        cbuff.put("孙");
        cbuff.put("悟");
        cbuff.put("空");

        cbuff.flip();
        // 转换成字节序列
        ByteBuffer bbuff = encoder.encode(cbuff);
        // 这里不能用bbuff.capacity().因为转换为字节序列后，capacity为原来CharBuffer的两倍
        for (int i = 0; i < bbuff.limit(); i++) {
            System.out.println(bbuff.get(i) + "");  // 绝对方式读取buffer里的值
        }
        // 转换成字符序列
        System.out.println("\n" + decoder.decode(bbuff));
    }
}
