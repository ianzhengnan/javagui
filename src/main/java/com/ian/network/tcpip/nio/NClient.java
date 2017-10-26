package com.ian.network.tcpip.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class NClient {

    private Selector selector = null;
    static final int PORT = 30000;
    private Charset charset = Charset.forName("UTF-8");
    //客户端socket
    private SocketChannel sc = null;

    public void init() throws IOException{

        selector = Selector.open();
        InetSocketAddress isa = new InetSocketAddress("127.0.0.1", PORT);
        sc = SocketChannel.open(isa);
        sc.configureBlocking(false);
        sc.register(selector, SelectionKey.OP_READ);
        // 启动读取服务器端数据的线程
        new ClientThread().start();
        // 创建键盘输入流
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            // 将键盘输入的内容输出到SocketChannel中
            sc.write(charset.encode(line));
        }

    }

    private class ClientThread extends Thread {

        public void run(){

            try{
                while (selector.select() > 0){
                    // 遍历每个有IO操作的Channel对应的SelectionKey
                    for (SelectionKey sk :
                            selector.selectedKeys()) {
                        // 删除正在处理的SelectionKey
                        selector.selectedKeys().remove(sk);
                        // 如果该SelectionKey对应的Channel中有可读的数据
                        if (sk.isReadable()){
                            // 使用NIO读取Channel的数据
                            SocketChannel sc = (SocketChannel)sk.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            String content = "";
                            while(sc.read(buffer) > 0){
                                sc.read(buffer);
                                buffer.flip();
                                content += charset.decode(buffer);
                            }
                            // 打印输出读取的内容
                            System.out.println("聊天信息：" + content);
                            // 为下一次读取做准备
                            sk.interestOps(SelectionKey.OP_READ);
                        }
                    }
                }
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new NClient().init();
    }

}
