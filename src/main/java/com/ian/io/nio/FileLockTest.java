package com.ian.io.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {

    public static void main(String[] args) throws IOException{
        try (
                FileChannel channel = new FileOutputStream("src/main/java/com/ian/io/nio/WriteFile.tmp").getChannel()
        ) {
            FileLock fileLock = channel.tryLock();
            Thread.sleep(10000);
            fileLock.release();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
