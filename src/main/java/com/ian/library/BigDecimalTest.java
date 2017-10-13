package com.ian.library;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal f1 = new BigDecimal("0.05"); // 推荐
        BigDecimal f2 = BigDecimal.valueOf(0.01); // 推荐
        BigDecimal f3 = new BigDecimal(0.05); // 不推荐

        System.out.println("使用String作为BigDecimal构造器参数：");
        System.out.println("0.05 + 0.01 = " + f1.add(f2));
        System.out.println("0.05 - 0.01 = " + f1.subtract(f2));
        System.out.println("0.05 * 0.01 = " + f1.multiply(f2));
        System.out.println("0.05 / 0.01 = " + f1.divide(f2));

        System.out.println("使用double作为BigDecimal构造器参数：");
        System.out.println("0.05 + 0.01 = " + f3.add(f2));
        System.out.println("0.05 - 0.01 = " + f3.subtract(f2));
        System.out.println("0.05 * 0.01 = " + f3.multiply(f2));
        System.out.println("0.05 / 0.01 = " + f3.divide(f2));

        /*
        * 使用String作为BigDecimal构造器参数：
        0.05 + 0.01 = 0.06
        0.05 - 0.01 = 0.04
        0.05 * 0.01 = 0.0005
        0.05 / 0.01 = 5
        使用double作为BigDecimal构造器参数：(如果直接使用float或者double类型计算也是这样) 这就是精度丢失
        0.05 + 0.01 = 0.06000000000000000277555756156289135105907917022705078125
        0.05 - 0.01 = 0.04000000000000000277555756156289135105907917022705078125
        0.05 * 0.01 = 0.0005000000000000000277555756156289135105907917022705078125
        0.05 / 0.01 = 5.000000000000000277555756156289135105907917022705078125

        * */
    }
}
