package com.ian.library.ext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CutString {

    public static void main(String[] args) {
        String str = "ABCDEFGHIJKLMN";
        // 匹配 CD
        Pattern pattern = Pattern.compile("CD");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
        // 匹配B, F
        Pattern pattern1 = Pattern.compile(".[BF]"); // 会匹配AB, EF
//        Pattern pattern1 = Pattern.compile("B|F");
        Matcher matcher1 = pattern1.matcher(str);
        while(matcher1.find()){
            System.out.println(matcher1.group());
        }
    }
}
