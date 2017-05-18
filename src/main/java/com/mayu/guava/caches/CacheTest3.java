package com.mayu.guava.caches;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 基于泛型的Callable Cache实现
 *
 * Author 卡卡
 * Created by jing on 2017/5/9.
 */
public class CacheTest3 {

    private static Cache<String, String> cacheFormCallable = null;

    /**
     * 对需要延迟处理的可以采用这个机制；(泛型的方式封装)
     * @param <K>
     * @param <V>
     * @return V
     * @throws Exception
     */
    public static <K, V> Cache<K, V> callableCached() throws Exception {
        Cache<K, V> cache = CacheBuilder.newBuilder()
                .maximumSize(10000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build();
        return cache;
    }

    private String getCallableCache(final String userName){
        try {
            //Callable只有在缓存值不存在时，才会调用
            return cacheFormCallable.get(userName, new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println(userName+" from db");
                    return "hello "+userName;
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Callable只有在缓存值不存在时，才会调用，比如第二次调用getCallableCache(u1name)直接返回缓存中的值
     * @throws Exception
     */
    @Test
    public void testCallableCache() throws Exception{
        final String u1 = "peida";
        final String u2 = "jerry";
        final String u3 = "lisa";
        cacheFormCallable = callableCached();
        System.out.println("peida:"+getCallableCache(u1));
        System.out.println("jerry:"+getCallableCache(u2));
        System.out.println("lisa:"+getCallableCache(u3));
        System.out.println("peida:"+getCallableCache(u1));
        System.out.println("jerry:"+getCallableCache(u2));
    }

}
