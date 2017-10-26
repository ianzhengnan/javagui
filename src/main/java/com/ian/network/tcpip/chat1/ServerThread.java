package com.ian.network.tcpip.chat1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread implements Runnable {

    private Socket socket;
    private BufferedReader br = null;

    public ServerThread(Socket socket) throws IOException{
        this.socket = socket;
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try{
            String content = null;
            while ((content = readFromClient()) != null){
                // 遍历socketList中的Socket
                // 将读取到的内容向每个Socket发送一次
                for (Socket s :
                        MyServer.socketList) {
                    PrintStream ps = new PrintStream(s.getOutputStream());
                    ps.println(content);
                }
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    private String readFromClient(){
        try{
            return br.readLine();
        }catch (IOException ioe){
            // 删除该socket
            MyServer.socketList.remove(socket);
        }
        return null;
    }
}
