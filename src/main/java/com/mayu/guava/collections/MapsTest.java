package com.mayu.guava.collections;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Author 卡卡
 * Created by jing on 2017/5/6.
 */
public class MapsTest {

    @Test
    public void testMaps(){

        /**
         * difference：返回两个给定map之间的差异。
         */
        Map<String, String> map1 = new HashMap<String, String>(){
            {
                put("a", "1");
            }
        };
        Map<String, String> map2 = new HashMap<String, String>(){
            {
                put("b", "2");
            }
        };
        Map<String, String> map3 = new HashMap<String, String>(){
            {
                put("a", "3");
            }
        };

        ////输出：not equal: only on left={a=1}: only on right={b=2}
        System.out.println(Maps.difference(map1, map2));
        //输出：not equal: value differences={a=(1, 3)}
        System.out.println(Maps.difference(map1, map3));

        /**
         * asMap：返回一个活动的map
         * 键值为给定的set中的值
         * value为通过给定Function计算后的值。
         */
        Set<String> sets = Sets.newHashSet("a", "b", "c");
        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };
        //输出：{b=B, c=C, a=A}
        System.out.println(Maps.asMap(sets, function));

        /**
         * transformValues：返回一个map映射
         * 其键值为给定fromMap的键值
         * 其value为给定formMap中value通过Function转换后的值
         */
        Map<String, Boolean> fromMap = Maps.newHashMap();
        fromMap.put("key", true);
        fromMap.put("value", false);
        //输出：{value=true, key=false}
        System.out.println(Maps.transformValues(fromMap, new Function<Boolean, Object>() {
            @Nullable
            @Override
            public Object apply(@Nullable Boolean input) {
                //对传入的元素取反
                return !input;
            }
        }));

        /**
         * transformEntries：返回一个map映射
         * 其Entry为给定fromMap.Entry通过给定EntryTransformer转换后的值
         */
        Maps.EntryTransformer<String, Boolean, String> entryTransformer =
                new Maps.EntryTransformer<String, Boolean, String>() {
                    @Override
                    public String transformEntry(@Nullable String key, @Nullable Boolean value) {
                        //value为假，则key变大写
                        return value ? key : key.toUpperCase();
                    }
                };
        //输出：{value=VALUE, key=key}
        System.out.println(Maps.transformEntries(fromMap,entryTransformer));


        /**
         * filterValues：返回给定unfilteredMap中的value值通过给定keyPredicate过滤后的map映射
         */
        //输出：{value=false}
        System.out.println(Maps.filterValues(fromMap, new Predicate<Boolean>() {
            @Override
            public boolean apply(@Nullable Boolean aBoolean) {
                //过滤Map中value值为假的元素
                return !aBoolean;
            }
        }));

        /**
         * filterEntries：返回给定unfilteredMap.Entry中的Entry值通过给定entryPredicate过滤后的map映射
         */
        System.out.println(Maps.filterEntries(fromMap, new Predicate<Map.Entry<String, Boolean>>() {
            @Override
            public boolean apply(@Nullable Map.Entry<String, Boolean> input) {
                //过滤Map.Entry中getValue()为真的元素
                return input.getValue();
            }
        }));



    }
}
