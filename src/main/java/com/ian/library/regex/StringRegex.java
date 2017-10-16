package com.ian.library.regex;

import java.util.Arrays;

public class StringRegex {

    public static void main(String[] args) {
        String[] msgs = {
                "Java has regular expression in 1.4",
                "regular expression now expressing in Java",
                "Java represses oracular expressions"
        };

        for (String msg :
                msgs) {
            System.out.println(msg.replaceFirst("re\\w*", "哈哈:)"));
            System.out.println(Arrays.toString(msg.split(" ")));
        }
    }
}
