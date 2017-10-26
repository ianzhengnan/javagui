package com.ian.network.tcpip.chat1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyServer {

    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException{

        ServerSocket ss = new ServerSocket(30000);
        while(true){
            // 此行代码会阻塞，将一直等待别人的连接
            Socket s = ss.accept();
            // 将其加入socket list中
            socketList.add(s);
            // 启动一个ServerThread线程为该客户端服务
            new Thread(new ServerThread(s)).start();
        }
    }
}
