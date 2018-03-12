package com.ian.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTst {

    public static void main(String[] args) throws IOException{

        File file = new File("src/main/java/com/ian/io/nio/FileChannelTst.java");
        try (
                FileChannel inChannel = new FileInputStream(file).getChannel();
                FileChannel outChannel = new FileOutputStream("src/main/java/com/ian/io/nio/FileChannelTst.tmp").getChannel()
        ) {
            // 将FileChannel里的全部数据映射成ByteBuffer
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY,
                    0, file.length());
            // 使用utf-8的字符集来创建解码器, 读取的文件是什么格式，这里就要用什么格式
            Charset charset = Charset.forName("UTF-8");
            // 直接将Buffer里的数据输出
            outChannel.write(buffer);
            // 复原position, limit
            buffer.flip(); // buffer.clear() 也可以
            // 创建解码器
            CharsetDecoder decoder = charset.newDecoder();
            // 使用解码器将ByteBuffer转换成CharBuffer
            CharBuffer charBuffer = decoder.decode(buffer);
            // CharBuffer的toString()方法可以获取对应的字符串
            System.out.println(charBuffer);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
