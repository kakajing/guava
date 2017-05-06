package com.mayu.guava.collections;

import java.util.IdentityHashMap;

/**
 * Author 卡卡
 * Created by jing on 2017/5/7.
 */
public class IdentityHashMapTest {
    public static void main(String[] args) {
        IdentityHashMap<String, String> map = new IdentityHashMap<>();
        map.put("test", "11");
        map.put("test", "22");

        System.out.println(map.containsKey("test"));
        System.out.println(map.size());
    }
}
