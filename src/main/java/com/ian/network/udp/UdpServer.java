package com.ian.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {

    public static final int PORT = 30000;
    private static int DATA_LEN = 4096;
    byte[] inBuff = new byte[DATA_LEN];
    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    private DatagramPacket outPacket;

    String[] movies = new String[]{
            "廊桥遗梦",
            "金刚",
            "王牌保镖",
            "生化危机"
    };

    public void init() throws Exception {

        try (
                DatagramSocket socket = new DatagramSocket(PORT)
        ) {
            for (int i = 0; i < 1000; i++) {
                // 读取socket里的数据，读到的数据放入inPacket封装的数组里
                socket.receive(inPacket);
                // 判断inPacket.getData()和inBuff是否同一个数组
                System.out.println(inBuff == inPacket.getData());
                // 将接收到的数据转换成字符串输出
                System.out.println(new String(inBuff, 0, inPacket.getLength()));
                // 从字符串数组中取出一个元素作为发送数据
                byte[] sendData = movies[i % 4].getBytes();
                // 以指定的字节数组作为发送目标，发送回去
                outPacket = new DatagramPacket(sendData, sendData.length, inPacket.getSocketAddress());
                // 发送数据
                socket.send(outPacket);
            }
        }
    }

    public static void main(String[] args) throws Exception{

        new UdpServer().init();
    }
}
