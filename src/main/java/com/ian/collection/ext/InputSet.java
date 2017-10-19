package com.ian.collection.ext;

import java.util.HashSet;
import java.util.Scanner;

public class InputSet {

    public static void main(String[] args) {

        HashSet<String> inputs = new HashSet<>();

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        while(sc.hasNext() && inputs.size() < 20){
            String input = sc.next();
            if (input != null){
                if(input.equals("exit")){
                    break;
                }
                if(!input.equals("")){
                    inputs.add(input);
                }
            }
        }
        System.out.println("您的输入是：" + inputs);
    }
}
