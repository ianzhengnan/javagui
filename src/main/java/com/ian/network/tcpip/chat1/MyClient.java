package com.ian.network.tcpip.chat1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MyClient {

    public static void main(String[] args) throws IOException{

        Socket s = new Socket("127.0.0.1", 30000);
        // 客户端启动ClientThread线程不断地读取来自服务器的数据
        new Thread(new ClientThread(s)).start();
        // 获取该Socket对应的输出流
        PrintStream ps = new PrintStream(s.getOutputStream());
        String line = null;
        // 不断地获取用户输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((line = br.readLine()) != null){
            // 将用户键盘输入的内容写入socket
            ps.println(line);
        }

    }
}
