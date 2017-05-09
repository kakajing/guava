package com.mayu.guava.caches;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.Callable;

/**
 * Author 卡卡
 * Created by jing on 2017/5/8.
 */
public class CacheTest {

    @Test
    public void TestLoadingCache() throws Exception{
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String s) throws Exception {
                        String strProValue = "hello " + s + "!";
                        return strProValue;
                    }
                });
        System.out.println("value: "+cache.apply("jerry"));
        System.out.println("value: "+cache.get("jerry"));
        System.out.println("value: "+cache.get("peida"));
        System.out.println("value: "+cache.apply("peida"));
        System.out.println("value: "+cache.apply("lisa"));
        cache.put("harry", "sddd");
        System.out.println("value: "+cache.get("harry"));
    }

    @Test
    public void testcallableCache() throws Exception{
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .build();
        String result = cache.get("jerry", new Callable<String>() {
            @Override
            public String call() throws Exception {
                String strProValue = "hello " + "jerry" + "!";
                return strProValue;
            }
        });
        System.out.println("jerry value: " + result);

        result = cache.get("peida", new Callable<String>() {
            @Override
            public String call() throws Exception {
                String strProValue = "hello " + "peipa" + "!";
                return strProValue;
            }
        });
        System.out.println("peida value: " + result);
    }



}
