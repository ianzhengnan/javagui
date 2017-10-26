package com.ian.network.tcpip.chat2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends Thread {

    private Socket socket;
    BufferedReader br = null;
    PrintStream ps = null;
    //
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try{
            // 获取该Socket对应的输入流
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 获取该Socket对应的输出流
            ps = new PrintStream(socket.getOutputStream());
            String line;
            while((line = br.readLine()) != null){
                if (line.startsWith(MyProtocol.USER_ROUND) && line.endsWith(MyProtocol.USER_ROUND)){
                    // 获取真实消息
                    String userName = getRealMsg(line);
                    // 如果用户名重复
                    if(Server.clients.map.containsKey(userName)){
                        System.out.println("用户名重复");
                        ps.println(MyProtocol.NAME_REP);
                    }else{
                        System.out.println("登录成功");
                        ps.println(MyProtocol.LOGIN_SUCCESS);
                        Server.clients.map.put(userName, ps);
                    }
                }
                // 如果读到的行以MyProtocol.PRIVATE_ROUND开头和结尾
                // 则可以确定是私聊信息，私聊信息只向特定的输出流发送
                else if(line.startsWith(MyProtocol.PRIVATE_ROUND) && line.endsWith(MyProtocol.PRIVATE_ROUND)){
                    // 得到真实信息
                    String userAndMsg = getRealMsg(line);
                    System.out.println(userAndMsg);
                    // 以MyProtocol.SPLIT_SIGN分割字符串，前半是私聊用户，后半是私聊信息
                    String[] content = userAndMsg.split(MyProtocol.SPLIT_SIGN);
                    String user = content[0];
                    String msg = content[1];
                    // 获取私聊用户对应的输出流，并发送私聊信息
                    Server.clients.map.get(user).println(Server.clients.getKeyByValue(ps) + "悄悄对你说：" + msg);
                    // 公聊要向每个Socket发送
                }else{
                    // 得到真实消息
                    System.out.println(line);
                    String msg = getRealMsg(line);
                    for(PrintStream clientPs : Server.clients.valueSet()){
                        clientPs.println(Server.clients.getKeyByValue(ps) + "说：" + msg);
                    }
                }
            }
        // 捕获到异常，表明该Socket有问题
        // 所以程序将其从后台Map删除
        }catch (IOException ioe){
            Server.clients.removeByValue(ps);
            System.out.println("共有" + Server.clients.map.size() + "个用户");
            // 关闭网络，IO资源
            try{
                if(br != null){
                    br.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(socket != null){
                    socket.close();
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
    // 将读到的内容去掉前后的协议字符，恢复成真实数据
    private String getRealMsg(String line) {
        return line.substring(MyProtocol.PROTOCOL_LEN, line.length() - MyProtocol.PROTOCOL_LEN);
    }
}
