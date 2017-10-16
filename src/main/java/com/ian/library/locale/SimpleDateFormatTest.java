package com.ian.library.locale;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {

    public static void main(String[] args) throws ParseException{

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("Gyyyy年终的第D天");
        String dateStr = simpleDateFormat.format(date);
        System.out.println(dateStr);
        // 一个非常特殊的日期字符串
        String str = "14###April##21";
        SimpleDateFormat sdf2 = new SimpleDateFormat("y###MMM##d");
        System.out.println(sdf2.parse(str));
    }
}
