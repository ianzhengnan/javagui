package com.ian.io.ext;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;


public class FilesCom {

    private String cmd;
    private final String[] cmds = {"cp", "mv", "del", "ll", "help", "cd"};
    private final File originPath = new File(".");
    private File currentPath = new File(".");
    private String source;
    private String target;

    private HandleDirFile fileDirHandler;

    public FilesCom(){
        this.fileDirHandler = new SimpleFileDirHandler();
    }

    public void initialize() throws Throwable{

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        // 打印命令前缀
        printCurrentPath(originPath);
        while(sc.hasNext()){
            String[] paths = sc.next().split("\\s+");

            if (!checkCommand(paths)){
                fileDirHandler.init();
                continue;
            }
            // handle command
            handleCmd();
            // reset
            fileDirHandler.init();
        }
        System.out.println("到这里了？");
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public static void main(String[] args) throws Throwable{

        new FilesCom().initialize();
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

    private void handleCmd() throws Throwable{

        switch (cmd){
            case "cd":
                handleCd();
                break;
            case "cp":
                handleCopy();
                break;
            case "mv":
                handleMove();
                break;
            case "ll":
                listAll();
                break;
            case "del":
                handleDelete();
                break;
            case "help":
                showHelp();
                break;
            default:
                break;
        }
    }

    private void handleCd() {

    }

    private void showHelp() {

    }

    private void handleDelete() throws IOException{
        fileDirHandler.deleteFile(new File(source));
        System.out.println("删除文件或目录....");
    }

    private void listAll() {
        int fileCount, dirCount;
        fileCount = dirCount = 0;
        for (File file:
             currentPath.listFiles()) {
            // 最后修改时间
            System.out.print((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(file.lastModified()) + " ");
            // 如果是目录就显示<DIR>
            System.out.print(file.isDirectory()? "<DIR>": " ");
            // 显示文件大小(字节)
            System.out.print(!file.isDirectory()? file.length() + " " : " ");
            // 显示文件或目录名
            System.out.println(file.getName());

            if (file.isDirectory()){
                dirCount++;
            }else{
                fileCount++;
            }
        }
        System.out.println("共" + fileCount + "个文件 " + dirCount + "个目录");
        printCurrentPath(originPath );
    }



    private void handleMove() throws IOException{
        fileDirHandler.move(source, target);
        System.out.println("移动文件或目录....");
    }

    private void handleCopy() throws IOException{
        // 如果源地址是文件
        if(!Files.isDirectory(Paths.get(source))){
            fileDirHandler.copy(source, target);
        }else{
            File file = new File(source);
            fileDirHandler.deepCopy(file, target);
        }
    }

    private void printCurrentPath(File file){
        String absPath = file.getAbsolutePath();
        System.out.print(absPath.substring(0,absPath.lastIndexOf("\\")) + ">");
    }

    private void setTargetAndSource(String[] paths){

        // 这里也很恶心

        if(paths[0].equals("") || paths[0].equals("help") || paths[0].equals("ll")){
            printCurrentPath(originPath);
            return;
        }
        setSource(paths[1]);
        if(paths[0].equals("ll") || paths[0].equals("del")){
            printCurrentPath(originPath);
            return;
        }
        setTarget(paths[2]);
    }

    private boolean checkCommand (String[] paths){
        // 此处应该改为正则表达式, 这里代码太恶心了！！

        if (!Arrays.asList(cmds).contains(paths[0])){
            System.out.println("没有此命令");
            printCurrentPath(originPath);
            return false;
        }

        if (paths.length > 3){
            System.out.println("您的输入不合法");
            printCurrentPath(originPath);
            return false;
        }

        if (paths.length == 1 && !paths[0].equals("help") && !paths[0].equals("") && !paths[0].equals("ll")){
            System.out.println("您的输入不合法");
            printCurrentPath(originPath);
            return false;
        }

        if (!paths[0].equals("help") && !paths[0].equals("ll")){

            if (!Files.exists(Paths.get(paths[1]))){
                System.out.println("源地址不存在！");
                printCurrentPath(originPath);
                return false;
            }

            if (paths[2] == null){
                System.out.println("请输入目标地址");
                printCurrentPath(originPath);
                return false;
            }

            if (!Files.exists(Paths.get(paths[2]))){
                System.out.println("目标地址不存在");
                printCurrentPath(originPath);
                return false;
            }
            if (!Files.isDirectory(Paths.get(paths[2]))){
                System.out.println("目标地址不是目录");
                printCurrentPath(originPath);
                return false;
            }
        }

        // 需要将相对路径转换成绝对路径
        setTargetAndSource(paths);
        // 如果检查都没错，设置cmd值
        setCmd(paths[0]);
        return true;
    }



}
