package com.ian.collection.set;

import java.util.TreeSet;

class M{
    int age;

    public M (int age){
        this.age = age;
    }
    public String toString(){
        return "M[age: " + age + "]";
    }

    public int getAge(){
        return this.age;
    }

}

public class TreeSetTest2 {

    public static void main(String[] args) {

        // Lambda表达式的目标类型是Comparator, 需要实现它的compare()方法
        TreeSet ts = new TreeSet((o1, o2) -> {
            M m1 = (M)o1;
            M m2 = (M)o2;
            return m1.getAge() - m2.getAge();
        });

        ts.add(new M(4));
        ts.add(new M(5));
        ts.add(new M(20));
        System.out.println(ts);
    }

}
