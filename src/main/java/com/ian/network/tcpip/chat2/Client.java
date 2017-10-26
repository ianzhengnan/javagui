package com.ian.network.tcpip.chat2;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private static final int SERVER_PORT = 30000;
    private Socket socket;
    private PrintStream ps;
    private BufferedReader brServer;
    private BufferedReader keyIn;

    public void init(){

        try{
            // 初始化代表键盘的输入流
            keyIn = new BufferedReader(new InputStreamReader(System.in));
            // 连接到服务器端
            socket = new Socket("127.0.0.1", SERVER_PORT);
            // 获取该Socket对应的输入流和输出流
            ps = new PrintStream(socket.getOutputStream());
            brServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String tip = "";
            // 采用循环不断地弹出对话框要求输入用户名
            while(true){
                String userName = JOptionPane.showInputDialog(tip + "输入用户名");
                // 在用户名前后增加协议字符串
                ps.println(MyProtocol.USER_ROUND + userName + MyProtocol.USER_ROUND);
                // 读取服务器端的响应
                String result = brServer.readLine();
                if (result.equals(MyProtocol.NAME_REP)){
                    tip = "用户名重复！请重新输入";
                    continue;
                }
                // 如果服务器端返回登录成功，则结束循环
                if(result.equals(MyProtocol.LOGIN_SUCCESS)){
                    break;
                }
            }
        }catch (UnknownHostException ex){
            System.out.println("找不到远程服务器，请确定服务器已经启动！");
            closeRs();
            System.exit(1);
        } catch (IOException ex){
            System.out.println("网络异常！请重新登录！");
            closeRs();
            System.exit(1);
        }
        // 新起一个线程来处理显示问题
        new ClientThread(brServer).start();
    }

    private void readAndSend(){
        try{
            //
            String line;
            while((line = keyIn.readLine()) != null){
                // 如果发送的信息中有冒号，且以//开头，则认为像发送私聊信息
                if (line.indexOf(":") > 0 && line.startsWith("//")){
                    line = line.substring(2);
                    ps.println(MyProtocol.PRIVATE_ROUND + line.split(":")[0] + MyProtocol.SPLIT_SIGN + line.split(":")[1]
                            + MyProtocol.SPLIT_SIGN + MyProtocol.PRIVATE_ROUND);
                }else{
                    ps.println(MyProtocol.MSG_ROUND + line + MyProtocol.MSG_ROUND);
                }
            }
        }catch (IOException ex){
            System.out.println("网络异常！请重新登录！");
            closeRs();
            System.exit(1);
        }
    }

    private void closeRs() {
        try{
            if(keyIn != null){
                keyIn.close();
            }
            if(brServer != null){
                brServer.close();
            }
            if (ps != null){
                ps.close();
            }
            if(socket != null){
                socket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.init();
        client.readAndSend();
    }
}
