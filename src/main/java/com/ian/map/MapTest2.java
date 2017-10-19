package com.ian.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest2 {

    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("廊桥遗梦", 80);
        map.put("星球大战", 100);
        map.put("金刚", 120);
        map.put("异形", 10);

        // “遗落战境”不存在， 所以不会插入
        map.replace("遗落战境", 20);
        System.out.println(map);

        map.putIfAbsent("遗落战境", 30);
        // 如果存在，不修改
        map.putIfAbsent("金刚", 20);
        System.out.println(map);

        // 使用原value和传入value计算新的value
        map.merge("金刚", 10,
                (oldVal, param) -> (Integer)oldVal + (Integer)param);
        System.out.println(map);
        // 如果key不存在，则使用计算结果作为value，插入新记录
        map.computeIfAbsent("疯狂野蛮人", (key) -> ((String)key).length());
        System.out.println(map);

        // 如果key 存在，则使用计算结果作为value
        map.computeIfPresent("疯狂野蛮人", (key, value) -> (Integer)value * (Integer)value);
        System.out.println(map);
    }
}
