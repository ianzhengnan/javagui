package com.ian.io;

import java.io.File;

public class FilenameFilterTest {

    public static void main(String[] args) {

        File file = new File(".");
        // 使用Lambda表达式，因为FilenameFilter接口只有一个方法。
        String[] nameList = file.list(((dir, name) -> name.endsWith(".java") || new File(name).isDirectory()));
        for(String name : nameList){
            System.out.println(name);
        }
    }
}
