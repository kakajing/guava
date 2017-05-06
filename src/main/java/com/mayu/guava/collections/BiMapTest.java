package com.mayu.guava.collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

/**
 * BiMap提供了一种新的集合类型，它提供了key和value的双向关联的数据结构。
 *
 * Author 卡卡
 * Created by jing on 2017/5/6.
 */
public class BiMapTest {

    @Test
    public void test(){
        //一个value只能有一个key  key value 都是唯一的
        HashBiMap<Object, Object> biMap = HashBiMap.create();
        biMap.put("1", "dog");
        //BiMap.forcePut 替换掉具有相同value的key
        //biMap.forcePut("2", "dog");
        biMap.forcePut("1","cat");

        //exp
       // biMap.put("2", "dog");
        System.out.println(biMap);

        //inverse 将key value 互换
        BiMap<Object, Object> inverseBiMap = biMap.inverse();
        System.out.println(inverseBiMap);
    }

    @Test
    public void test2(){
        HashBiMap<Object, Object> fileMap = HashBiMap.create();
        fileMap.put(1, "a.file");
        fileMap.put(2, "b.file");
        fileMap.put(3, "c.file");
      //  fileMap.put(4, "c.file");
        System.out.println("fileMap: "+fileMap);
        BiMap<Object, Object> inverseFileMap = fileMap.inverse();
        System.out.println("inverseFileMap: "+inverseFileMap);

        fileMap.put(4, "d.file");

        System.out.println("fileMap: "+fileMap);

        System.out.println("inverseFileMap: "+inverseFileMap);

    }
}
