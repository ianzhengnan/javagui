package com.ian.library.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchTest {

    public static void main(String[] args) {
        String[] mails = {
                "flks555@163.com",
                "kaka@qq.com",
                "kaka1982@#$5.com",
                "12@kaka.com",  // 最小的是3位
                "123456789012345678901@kaka.com" // 超过20位了
        };

        String maiRegEx = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
        Pattern mailPattern = Pattern.compile(maiRegEx);
        Matcher matcher = null;
        for (String mail :
                mails) {
            if (matcher == null) {
                matcher = mailPattern.matcher(mail);
            } else {
                // reset()方法，重置Matcher的匹配对象
                matcher.reset(mail);
            }
            String result = mail + (matcher.matches() ? "是" : "不是") + "一个有效的邮件地址！";
            System.out.println(result);
        }
    }
}
