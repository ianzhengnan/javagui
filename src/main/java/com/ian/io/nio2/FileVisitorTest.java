package com.ian.io.nio2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

/**
 * 遍历指定目录里的文件和子目录，查找制定文件，并打印文件内容
 */
public class FileVisitorTest {

    public static void main(String[] args) throws Exception{
        // 书中的SimpleFileVisitor的构造方法已经变成protected, 需要自己继承这个类在进行操作，不如进行
        Files.walkFileTree(Paths.get("c:", "Users", "i076453", "git"), new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("正在访问：" + dir + " 目录");
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("正在访问：" + file + " 文件");
                if (file.endsWith("FileVisitorTest.java")){
                    System.out.println("--已经找到目标文件--");
                    System.out.println("--文件内容如下--");
                    Stream<String> stream = Files.lines(file, Charset.forName("UTF-8"));
                    stream.forEach(line -> System.out.println(line));
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
