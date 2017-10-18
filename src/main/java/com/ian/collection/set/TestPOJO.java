package com.ian.collection.set;

import java.util.TreeSet;

public class TestPOJO implements Comparable<TestPOJO> {

    String name;
    int age;

    public TestPOJO(String name, int age){
        this.name = name;
        this.age = age;
    }

    // 这里通过泛型，设置compareTo(T anotherObj)中anotherObj的类型
    public int compareTo(TestPOJO obj) {
        // 如果年龄相等，比较两人姓名
        if ((age - obj.age) == 0){
            return name.compareTo(obj.name);
        }
        return age - obj.age;
    }

    public String toString(){
        return "name: " + name + " age: " + age;
    }

    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add(new TestPOJO("张三", 39));
        ts.add(new TestPOJO("李四", 22));
        ts.add(new TestPOJO("王二麻子", 55));
        ts.add(new TestPOJO("kaka", 22));
        // 运行时异常 java.lang.ClassCastException: com.ian.collection.set.Inside
        // cannot be cast to java.lang.Comparable
//        ts.add(new Inside());

        System.out.println(ts);
    }
}

class Inside {}
