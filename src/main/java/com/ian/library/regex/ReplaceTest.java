package com.ian.library.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTest {

    public static void main(String[] args) {

        String[] msgs = {
                "Java has regular expression in 1.4",
                "regular expression now expressing in Java",
                "Java represses oracular expressions"
        };

//        Pattern p = Pattern.compile("re\\w*");
        Pattern p = Pattern.compile("re\\w*?");
        Matcher matcher = null;
        for (int i = 0; i < msgs.length; i++) {
            if (matcher == null){
                matcher = p.matcher(msgs[i]);
            }else{
                matcher.reset(msgs[i]);
            }
            System.out.println(matcher.replaceAll("哈哈:)"));
        }
    }
}
