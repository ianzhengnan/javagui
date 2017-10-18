package com.ian.collection.set;

import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {

        TreeSet treeSet = new TreeSet();
        treeSet.add("王阳明心学");
        treeSet.add("疯狂java讲义");
        treeSet.add("abc之歌");
        System.out.println(treeSet);

        System.out.println(treeSet.comparator());
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        // 不包含自身
        System.out.println(treeSet.headSet("王阳明心学"));
        // 包含自身
        System.out.println(treeSet.tailSet("王阳明心学"));
        // 不包含自身
        System.out.println(treeSet.subSet("abc之歌", "王阳明心学"));


    }
}
