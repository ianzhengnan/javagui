package com.ian.io;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TypeInTest {

    public static void main(String[] args) throws IOException{

        //实现1 使用字符流
        /*try (
                // 将字节流InputStream转换成字符流Reader
                InputStreamReader inputStreamReader = new InputStreamReader(System.in)
        ) {
            char[] chars = new char[1024];
            int hasRead;
            while((hasRead = inputStreamReader.read(chars)) > 0){
                System.out.println(new String(chars, 0, hasRead));
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }*/

        //实现2 使用处理流
        try (
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            String line;
            while((line = bufferedReader.readLine()) != null){
                if (line.equals("exit")){
                    System.exit(1);
                }
                System.out.println("输入的内容为：" + line);
            }
        }catch (IOException eio){
            eio.printStackTrace();
        }
    }
}
