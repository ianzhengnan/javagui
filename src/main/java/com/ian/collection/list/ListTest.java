package com.ian.collection.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {

        List movies = new ArrayList();
        movies.add("异星觉醒");
        movies.add("罗马假日");
        movies.add("疯狂的石头");
        System.out.println(movies);

        movies.add(1, new String("星球大战"));
        System.out.println(movies);

        movies.remove(2);
        System.out.println(movies);

        System.out.println(movies.indexOf("疯狂的石头"));

        movies.set(1, "廊桥遗梦");
        System.out.println(movies);

        System.out.println(movies.subList(1,2));

        movies.add("禁闭岛");
        movies.sort((o1, o2) ->
            ((String)o1).length() - ((String)o2).length()
        );

        System.out.println(movies);

        movies.replaceAll(ele -> ((String)ele).length());
        System.out.println(movies);
    }
}
