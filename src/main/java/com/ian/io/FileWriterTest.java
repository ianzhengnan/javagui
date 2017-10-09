package com.ian.io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

    public static void main(String[] args) throws IOException{

        try (
                FileWriter fileWriter = new FileWriter("src/main/java/com/ian/io/FileWriterTest.tmp")
        ) {
//            fileWriter.如何设置字符编码，目前会自动产生GB2312的文件
            fileWriter.write("李白 - 静夜思 \r\n");
            fileWriter.write("窗前明月光，疑似地上霜 \r\n");
            fileWriter.write("举头望明月，低头思故乡 \r\n");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
