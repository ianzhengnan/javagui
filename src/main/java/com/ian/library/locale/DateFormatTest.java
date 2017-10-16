package com.ian.library.locale;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest
{
    public static void main(String[] args) throws Exception
    {
        Date dt = new Date();
        Locale[] locales = {Locale.CHINA, Locale.US};
        DateFormat[] df = new DateFormat[24];
        for (int i = 0; i < locales.length; i++) {
            df[i * 8] = DateFormat.getDateInstance(DateFormat.SHORT, locales[i]);
            df[i * 8 + 1] = DateFormat.getDateInstance(DateFormat.MEDIUM, locales[i]);
            df[i * 8 + 2] = DateFormat.getDateInstance(DateFormat.LONG, locales[i]);
            df[i * 8 + 3] = DateFormat.getDateInstance(DateFormat.FULL, locales[i]);
            df[i * 8 + 4] = DateFormat.getTimeInstance(DateFormat.SHORT, locales[i]);
            df[i * 8 + 5] = DateFormat.getTimeInstance(DateFormat.MEDIUM, locales[i]);
            df[i * 8 + 6] = DateFormat.getTimeInstance(DateFormat.LONG, locales[i]);
            df[i * 8 + 7] = DateFormat.getTimeInstance(DateFormat.FULL, locales[i]);
            df[i * 8 + 8] = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.DEFAULT, locales[i]);
            df[i * 8 + 9] = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.DEFAULT, locales[i]);
            df[i * 8 + 10] = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.DEFAULT, locales[i]);
            df[i * 8 + 11] = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.DEFAULT, locales[i]);
        }

        for (int i = 0; i < locales.length; i++) {
            String tip = i == 0 ? "-----中国的日期格式-----" : "-----美国的日期格式-----";
            System.out.println(tip);
            System.out.println("SHORT格式的日期格式：" + df[i * 8].format(dt));
            System.out.println("MEDIUM格式的日期格式：" + df[i * 8 + 1].format(dt));
            System.out.println("LONG格式的日期格式：" + df[i * 8 + 2].format(dt));
            System.out.println("FULL格式的日期格式：" + df[i * 8 + 3].format(dt));
            System.out.println("SHORT格式的时间格式：" + df[i * 8 + 4].format(dt));
            System.out.println("MEDIUM格式的时间格式：" + df[i * 8 + 5].format(dt));
            System.out.println("LONG格式的时间格式：" + df[i * 8 + 6].format(dt));
            System.out.println("FULL格式的时间格式：" + df[i * 8 + 7].format(dt));
            System.out.println("SHORT格式的时间日期格式：" + df[i * 8 + 8].format(dt));
            System.out.println("MEDIUM格式的时间日期格式：" + df[i * 8 + 9].format(dt));
            System.out.println("LONG格式的时间日期格式：" + df[i * 8 + 10].format(dt));
            System.out.println("FULL格式的时间日期格式：" + df[i * 8 + 11].format(dt));
        }

        String str1 = "2014.12.12";
        String str2 = "2014年12月10日";
        System.out.println(DateFormat.getDateInstance().parse(str1));
        System.out.println(DateFormat.getDateInstance(DateFormat.LONG).parse(str2));

    }
}
