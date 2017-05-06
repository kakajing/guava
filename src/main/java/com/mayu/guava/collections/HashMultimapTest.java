package com.mayu.guava.collections;

import com.google.common.collect.HashMultimap;
import org.junit.Test;

/**
 * Author 卡卡
 * Created by jing on 2017/5/6.
 */
public class HashMultimapTest {

    @Test
    public void test(){
        //一个key对应多个值，key:set 格式，一个key对应的值不能重复
        HashMultimap<String, String> hashMultimap = HashMultimap.create();
        hashMultimap.put("test", "1");
        hashMultimap.put("test", "2");
        hashMultimap.put("test", "3");
        //重复过滤掉 底层用set
        //hashMultimap.put("test", "3");
        System.out.println(hashMultimap.get("test"));
    }

    @Test
    public void testKey(){
        HashMultimap<String, String> hashMultimap = HashMultimap.create();
        hashMultimap.put("test", "1");
        hashMultimap.put("test", "2");
        hashMultimap.put("test2", "3");
        hashMultimap.put("test2", "4");

        System.out.println(hashMultimap.keySet());
        System.out.println(hashMultimap.asMap());
        System.out.println(hashMultimap.keys());

    }
}
