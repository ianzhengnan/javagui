package com.ian.library.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("a*b");
        Matcher matcher = pattern.matcher("aaaaaab");
        System.out.println("aaaaaab是否匹配a*b: " + matcher.matches());

        System.out.println("静态方法aaaaaab是否匹配a*b :" + Pattern.matches("a*b", "aaaaab"));

        String str = "求购二手电脑，电话号码：13523450987; 求购二手车：13790387645; 求购二手手机：15809387498";
        Matcher m = Pattern.compile("((13\\d)|(15\\d))\\d{8}").matcher(str);
        // 依次取出三个电话号码
        while(m.find()){
            System.out.println(m.group());
        }
    }

}
