package com.ian.library.ext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CutString2 {

    public static void main(String[] args) {

        String str = "A1B2C3D4E5F6G7H8";
        int[] ints = new int[8];
        String[] strs = new String[8];

        String regex = "[A-H]|\\d";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        int i = 0;
        while (matcher.find()) {
            if(i % 2 == 0){
                strs[i / 2] = matcher.group();
            }else{
                ints[i / 2] = Integer.valueOf(matcher.group());
            }
            i++;
        }

        for (int k = 0; k < 8; k++) {
            System.out.println(strs[k] + "====" + ints[k]);
        }
    }
}
