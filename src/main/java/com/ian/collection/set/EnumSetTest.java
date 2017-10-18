package com.ian.collection.set;

import java.util.EnumSet;

enum Season {
    SPRING, SUMMER, FALL, WINTER
}

public class EnumSetTest {

    public static void main(String[] args) {
        EnumSet es1 = EnumSet.allOf(Season.class);
        System.out.println(es1);

        EnumSet es2 = EnumSet.noneOf(Season.class);
        System.out.println(es2);

        es2.add(Season.SUMMER);
        es2.add(Season.FALL);
        System.out.println(es2);

        EnumSet es3 = EnumSet.of(Season.WINTER, Season.SUMMER);
        System.out.println(es3);

        EnumSet es4 = EnumSet.range(Season.SPRING, Season.FALL);
        System.out.println(es4);

        // es5 包含es4里剩下的所有Season里的枚举值
        EnumSet es5 = EnumSet.complementOf(es4);
        System.out.println(es5);

    }
}
