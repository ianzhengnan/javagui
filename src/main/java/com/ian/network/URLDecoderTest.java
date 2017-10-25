package com.ian.network;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderTest {

    public static void main(String[] args) throws Exception{

        String keyWord = URLDecoder.decode("%e7%96%af%e7%8b%82java%e8%ae%b2%e4%b9%89", "utf-8");
        System.out.println(keyWord);
        String urlStr = URLEncoder.encode(keyWord, "utf-8");
        System.out.println(urlStr);
    }
}
