package com.ian.io.ext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class SimpleFileDirHandler implements HandleDirFile{

    private String source;
    private String target;

    private void initialize() throws Throwable{
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        while(sc.hasNext()){
            String[] paths = sc.next().split("\\s+");
            source = paths[0];
            target = paths[1];
            if(!checkFileDirExists()){
                init();
                continue;
            }
            // 如果源地址是文件
            if(!Files.isDirectory(Paths.get(source))){
                copy(source, target);
            }else{
                File file = new File(source);
                deepCopy(file, target);
            }
            init();
        }
    }

    public static void main(String[] args) throws Throwable{

        new SimpleFileDirHandler().initialize();
    }

    public void deepCopy(File dir, String targetPath) throws IOException{
        // 获取目标目录路径
        targetPath += "/" + dir.getName();
        File targetDir = new File(targetPath);
        // 如果目标目录不存在，创建目标目录
        if (!targetDir.exists()){
            targetDir.mkdir();
        }
        // 获取当前路径下的所有目录和文件
        File[] files = dir.listFiles();
        for(File file : files){
            if (file.isDirectory()){
                deepCopy(file, targetPath);
            }else{
                copy(file.getAbsolutePath(), targetPath);
            }
        }
    }

    // 递归深度可以设置
    public void deepCopy (File file, String targetPath, int... more) throws IOException {
        deepCopy(file, targetPath);
    }

    public void init (){
        setSource("");
        setTarget("");
    }

    public void cd(){

    }

    public void copy(String sourcePath, String targetPath) throws IOException{

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

    @Override
    public void move(String sourcePath, String targetPath) throws IOException {

    }

    @Override
    public void deleteFile(File file) throws IOException {

    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    private boolean checkFileDirExists(){
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

    private String getFilename(String path){
        path = path.replace("\\", "/");
        int last = path.lastIndexOf("/");
        return path.substring(last);
    }
}
