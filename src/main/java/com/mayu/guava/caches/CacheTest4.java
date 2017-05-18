package com.mayu.guava.caches;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * Author 卡卡
 * Created by jing on 2017/5/9.
 */
public class CacheTest4 {
    static Map<String, Integer> map = Maps.newConcurrentMap();

    public static Integer getValueByKey(String key){
        System.out.println("通过key：" + key + "获取值");
        return map.get(key);
    }

    @Test
    public void loadingCache() throws Exception{
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);

        LoadingCache<String, Integer> build = CacheBuilder.newBuilder()
                .maximumSize(3)
                .build(new CacheLoader<String, Integer>() {
                    @Override
                    public Integer load(String key) throws Exception {
                        return getValueByKey(key);
                    }
                });
        System.out.println(build.get("key1"));
        System.out.println(build.get("key2"));
        System.out.println(build.get("key3"));
        build.put("key1", 4);
        System.out.println(build.get("key1"));
    }
}
