package com.mayu.guava.collections;

import com.google.common.collect.ArrayListMultimap;
import org.junit.Test;

/**
 * Author 卡卡
 * Created by jing on 2017/5/6.
 */
public class ArrayLIstMultimapTest {

    @Test
    public void test(){
        //一个key对应多个值，key:ArrayList 格式,支持一个key对应重复的值
        ArrayListMultimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("test", "1");
        multimap.put("test", "2");
        multimap.put("test", "3");
        multimap.put("test", "3");
        System.out.println(multimap.get("test"));
        System.out.println(multimap.containsValue("2"));
        System.out.println(multimap.containsKey("test1"));
    }
}
