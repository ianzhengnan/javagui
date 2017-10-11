package com.ian.io.ext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CopyDirFiles {

    private static String source;
    private static String target;
    
    public static void main(String[] args) throws Throwable{

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        while(sc.hasNext()){
            String[] paths = sc.next().split(" ");
            source = paths[0];
            target = paths[1];
            if(!checkFileDirExists()){
                continue;
            }
            // 如果源地址是文件
            if(!Files.isDirectory(Paths.get(source))){
                copy(source, target);
            }else{
                deepCopy(source);
            }

        }

    }

    private static void deepCopy(String path){
        String folderName = path.substring(path.lastIndexOf("/"));
//        Path
        File file = new File(path);
        for(String value : file.list()){
            File tmp = new File(value);
            if (tmp.isDirectory()){
                deepCopy(value);
            }else{
                
            }
        }
    }

    private static void deepCopy(String path, int... more){
        deepCopy(path);
    }

    private static boolean checkFileDirExists(){
        if (target == null){
            System.out.println("请输入目标地址");
            return false;
        }
        if (!Files.exists(Paths.get(source))){
            System.out.println("源地址不存在！");
            return false;
        }
        if (!Files.exists(Paths.get(target))){
            System.out.println("目标地址不存在");
            return false;
        }
        if (!Files.isDirectory(Paths.get(target))){
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
