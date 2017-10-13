package com.ian.library;

import java.util.Objects;

public class ObjectsTest {

    static ObjectsTest obj;
    static String test = "kaka";
    public static void main(String[] args) {
        System.out.println(Objects.hashCode(obj));
        System.out.println(Objects.hashCode(test));
        System.out.println(test.hashCode());

        System.out.println(Objects.toString(obj));
        System.out.println(Objects.toString(test));

        // 通常用来判断输入参数是否为null，如果为null，抛出异常;不为空则进行赋值
//        System.out.println(Objects.requireNonNull(obj, "obj参数不能为null！"));
        System.out.println(Objects.requireNonNull(test, "test参数不能为null！"));
    }
}
