package com.ian.network.tcpip.chat2;

import java.util.*;

public class MyMap<K, V> {

    // 创建一个线程安全的HashMap
    public Map<K, V> map = Collections.synchronizedMap(new HashMap<>());
    // 根据value来删除指定项
    public synchronized void removeByValue(Object value){
        for (Object key :
                map.keySet()) {
            if(map.get(key) == value){
                map.remove(key);
                break;
            }
        }
    }

    // 获取所有value组成的Set集合
    public synchronized Set<V> valueSet(){
        Set<V> result = new HashSet<>();
        map.forEach((key, value) -> result.add(value));
        return result;
    }

    // 根据value查找key
    public synchronized K getKeyByValue(V value){
        // 遍历所有key组成的集合
        for(K key : map.keySet()){
            if(map.get(key) == value || map.get(key).equals(value)){
                return key;
            }
        }
        return null;
    }

    // 实现put方法， 该方法不允许有重复值
    public synchronized V put(K key, V value){
        for(V val : valueSet()){
            // 如果某个value与试图放入集合的value相同
            // 则抛出一个Runtime异常
            if(val.equals(value) && val.hashCode() == value.hashCode()){
                throw new RuntimeException("MyMap实例中不允许有重复value!");
            }
        }
        return map.put(key, value);
    }
}
