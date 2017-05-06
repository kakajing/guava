package com.mayu.guava.collections;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Author 卡卡
 * Created by jing on 2017/5/7.
 */
public class PeekingIteratorTest {

    /**
     * 此demo，项目中直接使用set就搞定了
     * 此处纯属test
     */
    @Test  //复制一个 List，并去除连续的重复元素。
    public void test(){

        List<String> sourceList = Lists.newArrayList();
        sourceList.add("one");
        sourceList.add("two");
        sourceList.add("two");
        sourceList.add("three");
        List<String> result = Lists.newArrayList();

        PeekingIterator<String> iter = Iterators.peekingIterator(sourceList.iterator());
        while (iter.hasNext()) {
            String current = iter.next();
            while (iter.hasNext() && iter.peek().equals(current)) {
                //跳过重复的元素
                iter.next();
            }
            result.add(current);
        }
        System.out.println(result);
    }

    public static Iterator<String> skipNulls(final Iterator<String> in){
        return new AbstractIterator<String>() {
            @Override
            protected String computeNext() {
                while (in.hasNext()) {
                    String s = in.next();
                    if (s != null){
                        return s;
                    }
                }
                return endOfData();
            }
        };
    }

    @Test
    public void test2(){
        Iterator<Integer> powersOfTwo = new AbstractSequentialIterator<Integer>(1) {// 注意初始值1!
            @Override
            protected Integer computeNext(Integer integer) {
                return (integer == 1 << 30) ? null : integer * 2;
            }
        };

    }
}
