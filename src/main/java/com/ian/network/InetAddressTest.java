package com.ian.network;

import java.net.InetAddress;

public class InetAddressTest {

    public static void main(String[] args) throws Exception{

        InetAddress ip = InetAddress.getByName("www.baidu.com");
        System.out.println("baidu是否可达？" + ip.isReachable(2000));
        System.out.println(ip.getHostAddress());
        System.out.println(ip.getHostName());
//        System.out.println("Canonical Host Name: " + ip.getCanonicalHostName());

        InetAddress localip = InetAddress.getByAddress(new byte[]{127,0,0,1});
        System.out.println("本机是否可达？" + localip.isReachable(2000));
        // 获得InetAddress的全限定名
        System.out.println(localip.getCanonicalHostName());

    }
}
