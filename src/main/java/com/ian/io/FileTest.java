package com.ian.io;

import java.io.File;
import java.io.IOException;

public class FileTest {

    public static void main(String[] args) throws IOException{
        File file = new File(".");
        // 直接获取文件名， 输出一点
        System.out.println(file.getName());
        // 获取相对路径的父路径可能会出错，下面返回null
        System.out.println(file.getParent());
        // 获取绝对路径
        System.out.println(file.getAbsoluteFile());
        // 获取绝对路径的父路径
        System.out.println(file.getAbsoluteFile().getParent());
        // 在当前路径下创建一个临时文件
        File tmpFile = File.createTempFile("aaa", ".tmp", file);
        // 指定当虚拟机退出的时候删除该文件
        tmpFile.deleteOnExit();

        File newFile = new File(System.currentTimeMillis() + ".tmp");
        System.out.println("newFile文件是否存在：" + newFile.exists());

        System.out.println("创建newFile文件");
        newFile.createNewFile();
        System.out.println("newFile文件是否存在：" + newFile.exists());
        // 将返回false, 因为文件已经存在
        System.out.println("newFile是否能再创建为文件夹：" + newFile.mkdir());
        String[] fileList = file.list();
        System.out.println("----当前路径下所有文件和目录如下----");
        for(String fileName : fileList){
            System.out.println(fileName);
        }
        // listRoots()静态方法列出所有的磁盘根路径
        File[] roots = File.listRoots();

        System.out.println("========系统所有的根路径如下=========");

        for (File root :
                roots) {
            System.out.println(root);
        }


    }
}
