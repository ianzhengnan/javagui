package com.ian.network.tcpip.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AIOServer {

    private static int PORT = 30000;
    final static String UTF_8 = "UTF-8";
    static List<AsynchronousSocketChannel> channelList = new ArrayList<>();
    static Map<String, AsynchronousSocketChannel> channelMap = Collections.synchronizedMap(new HashMap<>());

    public void startListen() throws Exception{

        System.out.println("Server listen on " + PORT);

        // 创建一个线程池
        ExecutorService executor = Executors.newFixedThreadPool(20);
        // 以指定线程池来创建一个 AsynchronousChannelGroup
        AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withThreadPool(executor);
        // 以指定AsynchronousChannelGroup来创建一个 AsynchronousServerSocketChannel
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open(channelGroup)
                .bind(new InetSocketAddress(PORT));
        // 使用CompletionHandler接收来自客户端的连接请求
        serverSocketChannel.accept(null, new AcceptHandler(serverSocketChannel));
        // 这里原书中没有，必须加上，不然程序直接退出
        while(true){
//            System.out.println("main thread");
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) throws Exception{
        AIOServer server = new AIOServer();
        server.startListen();
    }

}


class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object>{

    private AsynchronousServerSocketChannel serverSocketChannel;

    public AcceptHandler(AsynchronousServerSocketChannel sc){
        this.serverSocketChannel = sc;
    }

    // 定义一个buffer准备读取数据
    ByteBuffer buffer = ByteBuffer.allocate(1024);

    @Override
    public void completed(AsynchronousSocketChannel sc, Object attachment) {
        // 记录进来的Channel
        AIOServer.channelList.add(sc);
        // 接收用户的下一次连接
        serverSocketChannel.accept(null, this);
        sc.read(buffer, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                buffer.flip();
                // 将Buffer中的内容转换为字符串
                String content = StandardCharsets.UTF_8.decode(buffer).toString();
                // 遍历每个channel, 将接收到的信息写入各个Channel
                for (AsynchronousSocketChannel c :
                        AIOServer.channelList) {
                    try{
                        c.write(ByteBuffer.wrap(content.getBytes(AIOServer.UTF_8))).get();
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
                buffer.clear();
                // 读取下一次数据
                sc.read(buffer, null, this);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("读取数据失败：" + exc);
                // 从该Channel中读取数据失败，就将该Channel删除
                AIOServer.channelList.remove(sc);
            }
        });
    }

    @Override
    public void failed(Throwable exc, Object attachment) {
        System.out.println("连接失败：" + exc);
    }
}