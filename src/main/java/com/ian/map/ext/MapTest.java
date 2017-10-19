package com.ian.map.ext;

import java.util.*;

public class MapTest {

    public static void main(String[] args) {

        String[] strs = {"a", "b", "a", "b", "c", "a", "b", "c", "b"};
        List<String> list = Arrays.asList(strs);
        Map<String, Integer> map = new HashMap<>();
        long start = System.currentTimeMillis();
//        for (int i = 0; i < list.size(); i++) {
//            map.put(list.get(i), Collections.frequency(list, list.get(i)));
//        }
        // 下面这种方法更快
//        for (int i = 0; i < list.size(); i++) {
//            map.put(list.get(i), map.get(list.get(i)) == null? 1 : map.get(list.get(i)) + 1);
//        }
        // 第三种方法更快
        for (int i = 0; i < strs.length; i++) {
            map.put(strs[i], map.get(strs[i]) == null ? 1 : map.get(strs[i]) + 1);
        }
        long end = System.currentTimeMillis();
        System.out.println(map);
        System.out.println(end - start);
    }
}
