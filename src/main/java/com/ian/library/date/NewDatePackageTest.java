package com.ian.library.date;

import com.sun.org.apache.xerces.internal.impl.dv.xs.YearMonthDV;

import java.time.*;
import java.time.zone.ZoneRules;

public class NewDatePackageTest {

    public static void main(String[] args) {

        Clock utcClock = Clock.systemUTC();
        Clock defaultClock = Clock.systemDefaultZone();
        // 获取当前utc时间
        System.out.println(utcClock.instant());
        // 这个也是utc时间
        System.out.println(defaultClock.instant());
        // 获取当前的时间戳，相当于System.currentTimeMillis()
        System.out.println(utcClock.millis());
        // 下面是关于Duration的用法
        Duration d = Duration.ofSeconds(6000);
        System.out.println("6000秒相当于" + d.toMinutes() + "分");
        System.out.println("6000秒相当于" + d.toHours() + "小时");
        System.out.println("6000秒相当于" + d.toDays() + "天");
        // 在Clock上增加6000秒，返回新的Clock
        Clock clock2 = Clock.offset(utcClock, d);
        // 可以看到clock2于utcclock相差1小时40分钟
        System.out.println("当前时刻加6000秒为：" + clock2.instant());

        // 下面是关于Instant用法
        Instant instant = Instant.now();
        System.out.println(instant);

        Instant instant2 = instant.plusSeconds(6000);
        System.out.println(instant2);

        Instant instant3 = Instant.parse("2017-10-23T10:20:35.234Z");
        System.out.println(instant3);
        // 获取instant3的基础上添加5小时4分钟
        Instant instant4 = instant3.plus(Duration.ofHours(5).plusMinutes(4));
        System.out.println(instant4);

        Instant instant5 = instant4.plus(Duration.ofDays(5));
        System.out.println(instant5);

        // ---- 下面是LocalDate的用法----
        System.out.println("---- 下面是LocalDate的用法----");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        localDate = LocalDate.of(2017, Month.APRIL, 20);
        System.out.println(localDate);

        // ---- 下面是关于LocalTime的用法 ----
        System.out.println("---- 下面是关于LocalTime的用法 ----");
        // 获取当前时间
        LocalTime localTime = LocalTime.now();
        // 设置为22点33分
        localTime = LocalTime.of(22, 33);
        System.out.println(localTime);

        localTime = LocalTime.ofSecondOfDay(5503);
        System.out.println(localTime);

        // ---- 下面是关于LocalDatetime的用法------
        // 获取当前的日期和时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime future = localDateTime.plusHours(5).plusMinutes(4);
        System.out.println(future);

        // ---- 下面是关于Year, YearMonth, MonthDay的用法----
        // 获取当前年
        Year year = Year.now();
        System.out.println("当前年是：" + year);
        year = year.plusYears(5);
        System.out.println("5年以后是：" + year);

        //
        YearMonth yearMonth = year.atMonth(10);
        System.out.println(yearMonth);
        yearMonth = yearMonth.plusYears(5).minusMonths(3);
        System.out.println(yearMonth);

        MonthDay monthDay = MonthDay.now();
        System.out.println(monthDay);
        MonthDay monthDay1 = monthDay.with(Month.APRIL);
        System.out.println(monthDay1);

    }

}
