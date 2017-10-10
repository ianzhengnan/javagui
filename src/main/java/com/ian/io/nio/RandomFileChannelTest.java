package com.ian.io.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class RandomFileChannelTest {

    public static void main(String[] args) throws IOException{

        File file = new File("src/main/java/com/ian/io/nio/test.txt");
        try (
                RandomAccessFile raf = new RandomAccessFile(file, "rw");
                FileChannel rafChannel = raf.getChannel()
        ) {
            ByteBuffer buffer = rafChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            // 把Channel的记录指针移到最后， 用于往里插入buffer的数据
            rafChannel.position(file.length());
            // 插入buffer中的数据
            rafChannel.write(buffer);
        }
    }
}
