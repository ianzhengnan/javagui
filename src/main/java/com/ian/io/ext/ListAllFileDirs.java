package com.ian.io.ext;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class ListAllFileDirs {

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");

        System.out.print("请输入路径：");
        while (sc.hasNext()){
            try {
                Path path = Paths.get(sc.next());
                if(!Files.exists(path)){
                    System.out.println("路径不存在！");
                    System.out.print("请再次输入路径：");
                    continue;
                }
                Files.walkFileTree(path, new FileVisitor<Path>() {
                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                        System.out.println("正在访问：" + dir + " 目录");
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        System.out.println("正在访问：" + file + " 文件");
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
                System.out.print("请输入路径：");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }
}
