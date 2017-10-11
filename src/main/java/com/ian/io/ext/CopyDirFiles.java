package com.ian.io.ext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CopyDirFiles {

    public static void main(String[] args) throws Throwable{

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        while(sc.hasNext()){
            String[] paths = sc.next().split(" ");
            if(!checkFileDirExists(paths)){
                continue;
            }
            // 如果源地址是文件
            if(!Files.isDirectory(Paths.get(paths[0]))){
                copy(paths[0], paths[1]);
            }else{
                File file = new File(paths[0]);

            }

        }

    }

    private static void deepCopy(String path){
        File file = new File(path);

    }

    private static void deepCopy(String path, int kak){
        deepCopy(path);
        File file = new File(path);

    }

    private static boolean checkFileDirExists(String[] paths){
        if (paths.length < 2){
            System.out.println("请输入目标地址");
            return false;
        }
        if (!Files.exists(Paths.get(paths[0]))){
            System.out.println("源地址不存在！");
            return false;
        }
        if (!Files.exists(Paths.get(paths[1]))){
            System.out.println("目标地址不存在");
            return false;
        }
        if (!Files.isDirectory(Paths.get(paths[1]))){
            System.out.println("目标地址不是目录");
            return false;
        }
        return true;
    }

    private static void copy(String sourcePath, String targetPath) throws IOException{

        String targetFileName = getFilename(sourcePath);

        try (
                FileInputStream inputStream = new FileInputStream(sourcePath);
                FileOutputStream outputStream = new FileOutputStream(targetPath + "/" + targetFileName)
        ) {
            byte[] bytes = new byte[256];
            int hasRead;
            while((hasRead = inputStream.read(bytes)) > 0){
                outputStream.write(bytes, 0, hasRead);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static String getFilename(String path){
        int last = path.lastIndexOf("/");
        return path.substring(last);
    }
}
