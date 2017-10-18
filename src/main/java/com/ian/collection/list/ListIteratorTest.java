package com.ian.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {

    public static void main(String[] args) {

        String[] movies = {"廊桥遗梦", "星球大战", "异星觉醒", "遗落战境"};

        List movieList = new ArrayList();
        for (int i = 0; i < movies.length; i++) {
            movieList.add(movies[i]);
        }
        // 这种方法创建的不是真正的ArrayList，它不可以新增，删除元素
//        movieList = Arrays.asList(movies);
        ListIterator lit = movieList.listIterator();
        System.out.println("============正向迭代==============");
        while(lit.hasNext()){
            System.out.println(lit.next());
            lit.add("------------分隔符-------------");
        }

        System.out.println("============下面开始反向迭代===============");
        while(lit.hasPrevious()){
            System.out.println(lit.previous());
        }
    }

}
