package com.ian.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("廊桥遗梦", 80);
        map.put("星球大战", 100);
        map.put("金刚", 120);
        System.out.println(map);

        map.put("金刚", 60);
        System.out.println(map);

        System.out.println("是否包含廊桥遗梦这部电影？" + map.containsKey("廊桥遗梦"));

        for (Object key :
                map.keySet()) {
            System.out.println(key + "-->" + map.get(key));
        }

        map.remove("星球大战");
        System.out.println(map);

        System.out.println(map.entrySet());

        System.out.println(map.values());
        System.out.println(map.keySet());

        System.out.println("map集合是否为空？" + map.isEmpty());
        map.clear();
        System.out.println("map集合是否为空？" + map.isEmpty());


    }
}
