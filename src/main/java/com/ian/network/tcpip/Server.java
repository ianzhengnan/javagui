package com.ian.network.tcpip;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException{

        // 创建一个ServerSocket，用于监听客户端Socket的请求
        ServerSocket ss = new ServerSocket(30000);
        // 不断循环地接收来自客户端的请求
        while(true){
            // 每当接收到客户端Socket的请求时，服务器端也对应产生一个Socket
            Socket s = ss.accept();
            PrintStream ps = new PrintStream(s.getOutputStream());
            ps.println("您好，您收到了来自服务器的万圣节祝福！");
            // 关闭输出流
            ps.close();
            // 关闭socket
            s.close();
        }

    }
}
