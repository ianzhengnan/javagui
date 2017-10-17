package com.ian.collection;

import java.util.stream.IntStream;

public class IntStreamTest {

    public static void main(String[] args) {

        IntStream is = IntStream.builder()
                .add(20)
                .add(12)
                .add(-13)
                .add(30)
                .build();

        System.out.println("is所有元素的最大值：" + is.max().getAsInt());
        System.out.println("is所有元素的最小值：" + is.min().getAsInt());
        System.out.println("is所有元素的总和：" + is.sum());
        System.out.println("is所有元素的总数：" + is.count());
        System.out.println("is所有元素的平均值：" + is.average());
        System.out.println("is所有元素的平方是否都大于20：" + is.allMatch(ele -> ele * ele > 20));
        System.out.println("is是否包含任何元素的平方大于20：" + is.anyMatch(ele -> ele * ele > 20));

        // 将is映射成为一个新的Stream, 新stream的每个元素都是原来stream的2倍+1
        IntStream newIs = is.map(ele -> ele * 2 + 1);
        // 使用方法引用的方式来遍历集合元素
        newIs.forEach(System.out::println);

    }
}
