package com.ian.io.ext;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class FilesCom {

    private String cmd;
    private final String[] cmds = {"cp", "mv", "del", "ll", "help"};
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

    private void showHelp() {

    }

    private void handleDelete() throws IOException{
        fileDirHandler.deleteFile(new File(source));
        System.out.println("删除文件或目录....");
    }

    private void listAll() {
        System.out.println("打印当前目录的文件和子目录名....");
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

    private void setTargetAndSouce(String[] paths){
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
        setTargetAndSouce(paths);
        // 如果检查都没错，设置cmd值
        setCmd(paths[0]);
        return true;
    }



}
