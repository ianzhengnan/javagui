package com.ian.collection;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class EnumerationTest {

    public static void main(String[] args) {

        Vector vector = new Vector();
        vector.add("kaka");
        vector.add("john");
        vector.add("Lynn");

        Hashtable hashtable = new Hashtable();
        hashtable.put("语文", 88);
        hashtable.put("数学", 90);

        // 相当于iterator()
        Enumeration em = vector.elements();
        while(em.hasMoreElements()){
            System.out.println(em.nextElement());
        }
        // 相当于keySet()
        Enumeration em1 = hashtable.keys();
        while(em1.hasMoreElements()){
            Object key = em1.nextElement();
            System.out.println(key + "--->" + hashtable.get(key));
        }
    }
}
