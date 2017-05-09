package com.mayu.guava.caches;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 一款面向本地缓存的，轻量级的Cache，适合缓存少量数据
 *
 * Author 卡卡
 * Created by jing on 2017/5/8.
 */
public class CacheTestTwo {
    final static Cache<Integer, String> cache = CacheBuilder.newBuilder()
            //设置cache的初始大小为10
            .initialCapacity(10)
            //设置并发数为5，即同一时间最多只能有5个线程往cache执行写入操作
            .concurrencyLevel(5)
            //设置容量数 当缓存数量达到或接近该最大值时，Cache将清除掉那些最近最少使用的缓存
            .maximumSize(10)
            //设置cache中的数据在写入之后的存活时间为10秒
            .expireAfterWrite(10, TimeUnit.SECONDS)
            //构建cache实例
            .build();


    @Test
    public void test(){
        cache.put(1, "test");
        cache.put(2, "test2");
        for (int i = 0; i < 10; i++) {
            //cache.getIfPresent 通过key获取缓存中的value，若不存在直接返回null
            System.out.println(cache.getIfPresent(1));
            System.out.println(cache.getIfPresent(2));

            //根据单个key 清除缓存
            cache.invalidate(1);
          //  cache.invalidateAll();

        }
    }
}
