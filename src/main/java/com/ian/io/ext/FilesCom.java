package com.ian.io.ext;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class FilesCom {

    private String cmd;
    private final String[] cmds = {"cp", "mv", "del", "ll", "help", "cd"};
    private final static File originPath = new File(".");
    private File currentPath;
    private String source;
    private String target;

    private HandleDirFile fileDirHandler;
    private Integer msgCode = 0;
    private final static Map<Integer, String> msgs = new HashMap<>();

    {
        msgs.put(1, "此命令不存在");
        msgs.put(2, "您的输入不合法");
        msgs.put(3, "源路径不存在");
        msgs.put(4, "源路径或目标路径不存在");
    }

    public FilesCom(){
        this.fileDirHandler = new SimpleFileDirHandler();
        try{
            currentPath = new File(originPath.getCanonicalPath());
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void initialize() throws Throwable{

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        // 打印命令前缀
        printCurrentPath();
        while(sc.hasNext()){
            String[] paths = sc.next().split("\\s+");

            try{
                if (!checkCommand(paths)){
                    System.out.println(msgs.get(getMsgCode()));
                    printCurrentPath();
                    fileDirHandler.init();
                    continue;
                }
            }catch (InputCheckException ice){
                System.out.println(ice.getMessage());
            }

            // handle command
            handleCmd();
            printCurrentPath();
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

    public Integer getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(Integer msgCode) {
        this.msgCode = msgCode;
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
        currentPath = new File(source);
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

    private void printCurrentPath() throws IOException{
        System.out.print(currentPath.getCanonicalPath() + ">");
//        String absPath = currentPath.getAbsolutePath();
//        System.out.print(absPath.substring(0,absPath.lastIndexOf("\\")) + ">");
    }

    private boolean checkCommand(String[] paths) throws Exception{

        boolean result = true;

        String one = "ll|help";
        String two = "ll|cd|del";
        String three = "cp|mv";

        // 检查输入命令是否合法
        if (!Arrays.asList(cmds).contains(paths[0])){
            setMsgCode(1);
            result = false;
        }else{
            // 设置命令
            setCmd(paths[0]);
        }
        // 无参数命令
        if (one.contains(paths[0])) {
            if (!paths[0].equals("ll") && paths.length != 1){
                setMsgCode(2);
                result = false;
            }
        }
        // 一个参数的命令
        if (two.contains(paths[0])){
            if(!paths[0].equals("ll") && paths.length != 2){
                setMsgCode(2);
                result = false;
            }else{
                if (!paths[0].equals("ll")){
                    // 检查源路径
                    File sourceFile = new File(Paths.get(currentPath.getCanonicalPath(), paths[1]).toString());
                    if (!sourceFile.exists()){
                        setMsgCode(3);
                        result = false;
                    }else{
                        // 设置源路径
                        setSource(sourceFile.getCanonicalPath());
                    }
                }else{
                    if (paths.length > 1 && !Files.exists(Paths.get(paths[1]))){
                        setMsgCode(3);
                        result = false;
                    }
                }

            }
        }
        // 两个参数的命令
        if(three.contains(paths[0])){
            if (paths.length != 3){
                setMsgCode(2);
                result = false;
            }else{
                // 检查源路径和目标路径
                if (!Files.exists(Paths.get(paths[1])) || !Files.exists(Paths.get(paths[2]))){
                    setMsgCode(4);
                    result = false;
                }else{
                    // 设置源路径
                    setSource(paths[1]);
                    // 设置目标路径
                    setTarget(paths[2]);
                }
            }
        }

        return result;
    }


}
