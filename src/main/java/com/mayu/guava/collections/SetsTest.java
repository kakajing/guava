package com.mayu.guava.collections;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

/**
 * Sets
 *
 * Author 卡卡
 * Created by jing on 2017/5/6.
 */
public class SetsTest {

    Set<Integer> set1;//测试用
    Set<Integer> set2;//测试用

    @Test
    public void testDifference(){
        HashSet<String> setOne = newHashSet("1", "2", "3");
        HashSet<String> setTwo = newHashSet("4", "2", "3");

        //获取setOne 中存在 setTwo中不存在的
        System.out.println(Sets.difference(setOne, setTwo));
        //获取setTwo 中存在 setOne中不存在的
        System.out.println(Sets.difference(setTwo, setOne));
        //获取setOne setTwo 差异的元素
        System.out.println(Sets.symmetricDifference(setTwo, setOne));
        //获取setOne setTwo 交集
        System.out.println(Sets.intersection(setOne, setTwo));
        //并集
        System.out.println(Sets.union(setOne, setTwo));

    }

    @Before
    public void setUp(){
        set1 = Sets.newHashSet(1, 2, 3, 4, 5);
        set2 = Sets.newHashSet(1, 3, 5, 7, 9);
    }

    /**
     * filter：返回传入Set集合unfiltered中满足给定Predicate的元素集合Set
     */
    @Test
    public void testFilter() {
        HashSet<String> set = Sets.newHashSet("i like u", "i miss u", "i love u");
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean apply(@Nullable String s) {
                return s.contains("l");
            }
        };
        //输出：[i like u, i love u]
        System.out.println(Sets.filter(set, predicate));
    }

    /**
     * cartesianProduct：返回通过从各给定集中选择一个元素所形成每一个可能的集合
     */
    @Test
    public void testCartesianProduct() {
        Set<String> set1 = Sets.newHashSet("i love u", "i hate u");
        Set<String> set2 = Sets.newHashSet("tom", "jerry");
        Set<List<String>> sets = Sets.cartesianProduct(set1, set2);
        System.out.println(sets);
    }

    /**
     * powerSet：返回一个set，包含给定set的所有可能父级集合
     */
    @Test
    public void testPowerSet() {
        HashSet<String> set = Sets.newHashSet("i love u", "i hate u");
        Set<Set<String>> sets = Sets.powerSet(set);
        for (Set<String> stringSet : sets) {
            System.out.println(stringSet);
        }
    }

}


