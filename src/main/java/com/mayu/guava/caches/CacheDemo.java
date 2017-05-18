package com.mayu.guava.caches;

import com.google.common.cache.*;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 *  * guava cache demo
 * 缓存相关类
 *
 * @see CacheBuilder ：设置LocalCache的相关参数，并创建LocalCache实例
 * @see CacheLoader ：其load()方法用于实现"取缓存-->若不存在，则先计算，缓存中存在-->取缓存"的原子操作
 * @see LocalCache : guava cache的核心类，包含了guava cache的数据结构以及基本的缓存的操作方法
 * @see LoadingCache :继承于Cache接口，定义了get(K key)
 * @see Cache : 定义了cache操作的相关接口,如 getIfPresent(Object key)和put(K key, V value)
 * @see LocalCache.LocalLoadingCache :LocalCache的一个静态内部类，其get(K key)是外部调用get(K key)入口
 * @see LocalCache.LocalManualCache ：LocalCache的一个静态内部类，是LocalLoadingCache的父类，
 * 这里的getIfPresent(Object key)和put(K key, V value)也是外部方法的入口
 *
 * Author 卡卡
 * Created by jing on 2017/5/9.
 */
public class CacheDemo {

    //构造缓存器,使用了构建器模式，该模式是在存在多个可选参数的情况的推荐使用的一种实现方式  大神Joshua Bloch 推荐的
    //他的effective Java 中有提到
    //CacheBuilder-->newBuilder()-->newCacheBuilder() 采用默认值创建实例
    LoadingCache<String, String> cache = CacheBuilder.newBuilder()
            // 缓存20分钟
            .expireAfterWrite(20, TimeUnit.MINUTES)
            // 最多缓存1000个对象
            .maximumSize(1000)
            //建立一个cache，该缓存器通过使用传入的CacheLoader，
            //既可以获取已给定key的value，也能够自动的计算和获取缓存（即get(Object key)的三步原子操作）
            //当然，这里是线程安全的，线程安全的运行方式与ConcurrentHashMap一致（分段锁）
            //该方法的返回值是一个LoadingCache接口的实现类LocalCache.LocalLoadingCache实例
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    //为 hi 时返回null 验证guava缓存 时load不能返回null
                    if (s.equals("hi")){
                        return null;
                    }
                    return s +" ,world";
                }
            });

    @Test
    public void test(){

        CacheDemo cacheDemo = new CacheDemo();
        //本地缓存中不存在  返回null
        System.out.println(cacheDemo.cache.getIfPresent("hello"));
        //本地设置缓存
        cacheDemo.cache.put("123", "test123");
        //获取存在的缓存
        System.out.println(cacheDemo.cache.getIfPresent("123"));
        //删除缓存
        cacheDemo.cache.invalidate("123");
        System.out.println(cacheDemo.cache.getIfPresent("123"));

        try {
            //get方法调用的是getOrLoad，获取不到数据时会执行load方法
            System.out.println(cacheDemo.cache.get("hello"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //返回 上一步get方法产生的数据
        System.out.println(cacheDemo.cache.getIfPresent("hello"));
        //缓存没有  返回null
        System.out.println(cacheDemo.cache.getIfPresent("hi"));
        //测试根据key=null 获取数据 会抛异常
        System.out.println(cacheDemo.cache.getIfPresent(null));
        try {
            //get方法会先从本地缓存中获取，如果获取不到，则会触发load方法，单load方法不能
            //返回null
            System.out.println(cacheDemo.cache.get("hi"));  //抛异常
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
