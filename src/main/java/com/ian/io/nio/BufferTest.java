package com.ian.io.nio;

import java.nio.CharBuffer;

public class BufferTest {

    public static void main(String[] args) {

        CharBuffer charBuffer = CharBuffer.allocate(8);
        printStatus(charBuffer);

        charBuffer.put('a');
        charBuffer.put('b');
        charBuffer.put('c');
        System.out.println("插入三条数据后....");
        printStatus(charBuffer);

        charBuffer.flip();
        System.out.println("调用flip()函数后....");
        printStatus(charBuffer);

        // 取出第一个元素
        System.out.println("读取第一个元素(position=0): " + charBuffer.get());
        printStatus(charBuffer);

        charBuffer.clear();
        System.out.println("调用clear()方法后....");
        printStatus(charBuffer);

        // get(2)为绝对读取，不影响position
        System.out.println("执行clear()后，缓冲区内容没有被清除：" + "第三个元素为：" + charBuffer.get(2));
        System.out.println("执行了绝对读取后....");
        printStatus(charBuffer);
    }

    private static void printStatus(CharBuffer charBuffer){
        System.out.println("当前的poistion = " + charBuffer.position());
        System.out.println("当前的limit = " + charBuffer.limit());
        System.out.println("Capacity = " + charBuffer.capacity());
    }
}
