package com.ian.network;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownThread extends Thread {

    private String path;
    private int startPos;
    private int currentPartSize;
    private RandomAccessFile currentPart;

    public int length;

    public DownThread(String path, int startPos, int currentPartSize, RandomAccessFile currentPart){
        this.path = path;
        this.currentPart = currentPart;
        this.startPos = startPos;
        this.currentPartSize = currentPartSize;
    }

    public void run(){
        try{
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(5 * 1000);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg");
            conn.setRequestProperty("Accept-Lanugage", "zh-CN");
            conn.setRequestProperty("Charset", "utf-8");
            InputStream inStream = conn.getInputStream();
            inStream.skip(this.startPos);
            byte[] buffer = new byte[1024];
            int hasRead;
            System.out.println(getName() + " downloading...");
            while (length < currentPartSize
                    && (hasRead = inStream.read(buffer)) != -1){
                currentPart.write(buffer, 0, hasRead);
                length += hasRead;
            }
            currentPart.close();
            inStream.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
