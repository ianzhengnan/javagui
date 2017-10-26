package com.ian.network.tcpip.chat2;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientThread extends Thread {

    private BufferedReader br = null;
    public ClientThread(BufferedReader br){
        this.br = br;
    }

    public void run(){

        try{
            String line;
            while((line = br.readLine()) != null){
                //
                System.out.println(line);
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            try{
                if(br != null){
                    br.close();
                }
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
}
