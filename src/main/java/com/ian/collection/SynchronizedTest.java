package com.ian.collection;

import java.util.*;

public class SynchronizedTest {

    public static void main(String[] args) {

        Collection c = Collections.synchronizedCollection(new ArrayList());
        List list = Collections.synchronizedList(new ArrayList());
        Set set = Collections.synchronizedSet(new HashSet());
        Map m = Collections.synchronizedMap(new HashMap());

    }
}
