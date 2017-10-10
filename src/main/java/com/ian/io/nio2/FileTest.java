package com.ian.io.nio2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileTest {

    public static void main(String[] args) throws IOException{

        Files.copy(Paths.get("src/main/java/com/ian/io/nio2/test.tmp"),
                new FileOutputStream("src/main/java/com/ian/io/nio2/test1.tmp"));

        System.out.println("test1.tmp是否为隐藏文件：" + Files.isHidden(Paths.get("src/main/java/com/ian/io/nio2/test1.tmp")));

        // 一次性读取test1.tmp的所有行
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/com/ian/io/nio2/test1.tmp"), Charset.forName("UTF-8"));
        System.out.println(lines);
        // 字节数byte UTF-8一个字符占三个字节，回车符占一个字节
        System.out.println("test1.tmp的大小为：" + Files.size(Paths.get("src/main/java/com/ian/io/nio2/test1.tmp")) + "字节");

        List<String> poem = new ArrayList<>();
        poem.add("春眠不觉晓");
        poem.add("处处闻啼鸟");

        Files.write(Paths.get("src/main/java/com/ian/io/nio2/poem.tmp"), poem, Charset.forName("UTF-8"))
                .forEach(line -> System.out.println(line));

        // 使用java8新增的Stream API 列出当前目录下所有文件和子目录
        Files.list(Paths.get(".")).forEach(path -> System.out.println(path));
        // 使用java8新增的Stream API 读取文件内容
        Files.lines(Paths.get("src/main/java/com/ian/io/nio2/poem.tmp")).forEach(line -> System.out.println(line));

        FileStore store = Files.getFileStore(Paths.get("c:"));
        // 判断C盘的总空间，可用空间
        System.out.println("C:共有空间：" + store.getTotalSpace());
        System.out.println("C:可用空间：" + store.getUsableSpace());
    }
}
