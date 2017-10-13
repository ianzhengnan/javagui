package com.ian.library;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {

    public static void main(String[] args) {

        Random rand = new Random();
        System.out.println("rand.nextBoolean(): " + rand.nextBoolean());

        byte[] bytes = new byte[16];
        rand.nextBytes(bytes);
        System.out.println(Arrays.toString(bytes));
        // 生成0.0~1.0之间的伪随机double数
        System.out.println("rand.nextDouble(): " + rand.nextDouble());
        // 生成0.0~1.0之间的伪随机double数
        System.out.println("rand.nextFloat(): " + rand.nextFloat());

        // 生成平均值是0.0, 标准差是 1.0 的伪高斯数
        System.out.println("rand.nextGaussian(): " + rand.nextGaussian());
        // 生成一个处于int整数取值范围的伪随机数
        System.out.println("rand.nextInt(): " + rand.nextInt());
        // 生成一个0~30之间的伪随机数
        System.out.println("rand.nextInt(): " + rand.nextInt(30));
        // 生成一个处于long整数取值范围的伪随机数
        System.out.println("rand.nextLong(): " + rand.nextLong());

        // Random使用一个48位种子，如果这个类的两个实例是用同一个种子创建的，对它们以同样的顺序调用方法，则他们会产生相同的
        // 数字序列。
        System.out.println("---------------------------------------");
        Random r1 = new Random(50);
        System.out.println("第一个种子为50的Random对象");
        System.out.println("r1.nextBoolean():\t" + r1.nextBoolean());
        System.out.println("r1.nextInt():\t\t" + r1.nextInt());
        System.out.println("r1.nextDouble():\t" + r1.nextDouble());
        System.out.println("---------------------------------------");

        Random r2 = new Random(50);
        System.out.println("第一个种子为50的Random对象");
        System.out.println("r2.nextBoolean():\t" + r2.nextBoolean());
        System.out.println("r2.nextInt():\t\t" + r2.nextInt());
        System.out.println("r2.nextDouble():\t" + r2.nextDouble());
        System.out.println("---------------------------------------");

        Random r3 = new Random(100);
        System.out.println("第一个种子为100的Random对象");
        System.out.println("r3.nextBoolean():\t" + r3.nextBoolean());
        System.out.println("r3.nextInt():\t\t" + r3.nextInt());
        System.out.println("r3.nextDouble():\t" + r3.nextDouble());
        System.out.println("---------------------------------------");

        // 所以通常推荐使用当时间戳当种子
        Random r4 = new Random(System.currentTimeMillis());
        System.out.println("第一个种子为UTC的Random对象");
        System.out.println("r4.nextBoolean():\t" + r4.nextBoolean());
        System.out.println("r4.nextInt():\t\t" + r4.nextInt());
        System.out.println("r4.nextDouble():\t" + r4.nextDouble());
        System.out.println("---------------------------------------");

        ThreadLocalRandom r5 = ThreadLocalRandom.current();
        // 生成一个4-20之间的伪随机数
        System.out.println(r5.nextInt(4, 20));
        System.out.println(r5.nextDouble(2.0, 10.0));

    }
}
