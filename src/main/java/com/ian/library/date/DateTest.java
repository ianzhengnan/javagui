package com.ian.library.date;

import java.util.Date;

public class DateTest {

    public static void main(String[] args) {
        Date d1 = new Date();
        // 获取当前之后100ms的时间
        Date d2 = new Date(System.currentTimeMillis() + 1000);
        System.out.println(d2);
        System.out.println(d1.compareTo(d2));
        System.out.println(d1.before(d2));
    }
}
