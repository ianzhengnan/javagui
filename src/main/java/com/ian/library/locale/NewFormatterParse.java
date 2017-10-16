package com.ian.library.locale;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewFormatterParse {

    public static void main(String[] args) {
        String str1 = "2017==04==12 01时06分09秒";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy==MM==dd HH时mm分ss秒");
        LocalDateTime dt1 = LocalDateTime.parse(str1, formatter1);
        System.out.println(dt1);

        String str2 = "2014$$$四月$$$13 20 小时";
        // 这里不能正常解析，后面再具体分析
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy$$$MMM$$$dd HH 小时");
        LocalDateTime dt2 = LocalDateTime.parse(str2, formatter2);
        System.out.println(dt2);
    }
}
