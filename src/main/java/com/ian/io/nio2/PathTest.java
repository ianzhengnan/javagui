package com.ian.io.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

    public static void main(String[] args) throws Exception{

        Path path = Paths.get(".");
        System.out.println("path里包含的路径数量：" + path.getNameCount());

        System.out.println("path的根路径：" + path.getRoot());

        Path absolutePath = path.toAbsolutePath();
        Path realPath = path.toRealPath();
        System.out.println("绝对路径：" + absolutePath);
        System.out.println("真实路径：" + realPath);

        System.out.println("absolutePath里包含的路径数量：" + absolutePath.getNameCount());
        System.out.println("realPath里包含的路径数量：" + realPath.getNameCount());

//        System.out.println(realPath.getName(0));
        for (int i = 0; i < absolutePath.getNameCount(); i++) {
            System.out.println(absolutePath.getName(i));
            // 输出的是当前文件夹到系统根目录的所有目录名
            // Users
            // i076453
            // git
            // java
            // javagui
        }

        Path makedPath = Paths.get("c:", "Users", "i076453-sss");
        System.out.println(makedPath);
    }
}
