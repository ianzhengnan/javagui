package com.ian.library.date;

import java.util.Calendar;
import java.util.Date;

public class CalenderTest {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        // calender转换成为Date
        Date date = calendar.getTime();
        System.out.println(date);
        // Date转换成Calender
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);
        System.out.println(calendar1);

        /*
        * Fri Oct 13 17:26:42 CST 2017
        java.util.GregorianCalendar[time=1507886802394,areFieldsSet=true,areAllFieldsSet=true,lenient=true,
        zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,
        useDaylight=false,transitions=19,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,
        ERA=1,YEAR=2017,MONTH=9,WEEK_OF_YEAR=41,WEEK_OF_MONTH=2,DAY_OF_MONTH=13,DAY_OF_YEAR=286,
        DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=5,HOUR_OF_DAY=17,MINUTE=26,SECOND=42,
        MILLISECOND=394,ZONE_OFFSET=28800000,DST_OFFSET=0]
        * */

        System.out.println(calendar1.getTime());
        System.out.println(calendar.getCalendarType()); // gregory
        System.out.println(calendar.getWeeksInWeekYear());
        System.out.println(calendar.getWeekYear());

        // 正值为加，负值为减
        calendar.add(Calendar.DATE, 30);
        System.out.println(calendar.getTime());

        calendar.roll(Calendar.DATE, 30);
        System.out.println(calendar.getTime());

        // 获得当前月的最大日期，比如十月最大日期31
        System.out.println(calendar.getActualMaximum(Calendar.DATE));
        System.out.println(calendar.getActualMinimum(Calendar.MONTH)); // 月从0开始，最大11

        System.out.println(calendar.get(Calendar.MONTH)); // 10 不是 9 （当前月是十月）

    }
}
