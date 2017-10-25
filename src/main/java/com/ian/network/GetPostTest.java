package com.ian.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class GetPostTest {

    private final static String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36)";

    public static String sendGet(String url, String param){

        String result = "";
        String urlName = url + "?" + param;
        try{
            URL realUrl = new URL(urlName);
            // 打开和URL之间的连接, 不是HTTPURLConnection
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", userAgent);
            // 建立实际连接
            conn.connect();
            // 获取所有的响应头字段
            Map<String, List<String>> head = conn.getHeaderFields();
            for (String key :
                    head.keySet()) {
                System.out.println(key + "--->" + head.get(key));
            }
            try (
                    // 定义处理流BufferedReader来读取URL的响应
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            ) {
                String line;
                while ((line = in.readLine()) != null){
                    result += "\n" + line;
                }
            }
        }catch (Exception ex){
            System.out.println("发送GET请求出现异常!" + ex);
            ex.printStackTrace();
        }
        return result;
    }

    public static String sendPost(String url, String param){
        String result = "";
        try{
            URL readUrl = new URL(url);
            URLConnection conn = readUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", userAgent);
            // 发送POST请求必须设置如下两行, GET请求不需要设置
            conn.setDoOutput(true);
            conn.setDoInput(true);

            try (
                    // 获取URLConnection对象对应的输出流
                    PrintWriter out = new PrintWriter(conn.getOutputStream())
            ) {
                // 发送请求
                out.print(param);
                // flush输出流的缓冲
                out.flush();
            }

            try (
                    // 定义BufferedReader输入流来读取URL的响应
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))
            ) {
                String line;
                while ((line = in.readLine()) != null){
                    result += "\n" + line;
                }
            }
        }catch (Exception ex){
            System.out.println("发送POST请求异常！" + ex);
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public static void main(String[] args) throws Exception{

        String get = sendGet("http://localhost:8100/account/login", null);
        System.out.println("get请求结果" + get);
        String post = sendPost("http://localhost:8100/account/login", "username=jan&password=jan1234");
        System.out.println("post请求结果：" + post);
    }

}
