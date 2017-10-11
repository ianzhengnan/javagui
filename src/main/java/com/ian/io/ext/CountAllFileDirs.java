package com.ian.io.ext;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class CountAllFileDirs {

    private static int dirCount;
    private static int fileCount;
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");

        while (sc.hasNext()){
            Path path = Paths.get(sc.next());
            if (!Files.exists(path)){
                System.out.println("路径不存在！");
                continue;
            }

            Files.walkFileTree(path, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    dirCount++;
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    fileCount++;
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

            System.out.println("共有 " + dirCount + " 个目录");
            System.out.println("共有 " + fileCount + " 个文件");
            dirCount = fileCount = 0;
        }
    }
}
