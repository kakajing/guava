package com.mayu.guava.collections;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *  不可变集合
 *
 * Author 卡卡
 * Created by jing on 2017/5/6.
 */
public class ImmutalbeMapTest {

    @Test
    public void testGuava(){
        ImmutableMap<String, String> map = ImmutableMap.of("1", "s", "2", "t");
        ////不可变的集合 发生变化 exp
       // map.put("1", "error");
        System.out.println(JSON.toJSONString(map));
    }

    @Test
    public void testJdk(){
        HashMap<Object, Object> map = Maps.newHashMap();
        map.put("1","sss");

        ////使用jdk Collections 转换
        Map<Object, Object> unmodifiableMap = Collections.unmodifiableMap(map);
        //也会抛exp
        //unmodifiableMap.put("1","555");
        System.out.println(JSON.toJSONString(map));
    }
}
