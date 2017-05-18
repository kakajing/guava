package com.mayu.guava.caches;

/**
 *  * CacheBuilder 相关属性的注释
 *
 * Author 卡卡
 * Created by jing on 2017/5/9.
 */
public class CacheBuilderNotes {

    //用于计算每个Segment中的hashtable的大小
    private static final  int DEFAULT_INITIAL_CAPACITY = 16;
    //用于计算有几个Segment
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    //默认的缓存过期时间
    private static final int DEFAULT_EXPIRATION_NANOS = 0;

    static final int UNSET_INT = -1;

    //用于计算每个Segment中的hashtable的大小
    int initialCapacity = UNSET_INT;
    //用于计算有几个Segment
    int concurrenncyLevel = UNSET_INT;
    //cache中最多能存放的缓存entry个数
    long maximumSize = UNSET_INT;
    long maximumWeight = UNSET_INT;

    //键的引用类型（strong、weak、soft）
//    Strength keyStrength;
    //值的引用类型（strong、weak、soft）
//    Strength valueStrength;

    //缓存超时时间（起点：缓存被创建或被修改）
    long expireAfterWriteNanos = UNSET_INT;
    //缓存超时时间（起点：缓存被创建或被修改或被访问）
    long expireAfterAccessNanos = UNSET_INT;

}
