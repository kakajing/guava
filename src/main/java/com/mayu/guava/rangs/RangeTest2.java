package com.mayu.guava.rangs;

import com.google.common.collect.Range;
import com.google.common.primitives.Ints;
import org.junit.Test;

/**
 * Author 卡卡
 * Created by jing on 2017/5/22.
 */
public class RangeTest2 {

    /**
     * //区间运算
     */
    @Test
    public void test1(){

        System.out.println(Range.closed(1, 3).contains(2));
        System.out.println(Range.closed(1, 3).contains(4));
        System.out.println(Range.lessThan(5).contains(5));
        System.out.println(Range.closed(1, 4).containsAll(Ints.asList(1, 2, 3)));

    }

    /**
     * 查询运算
     */
    @Test
    public void test2(){

        System.out.println(Range.closedOpen(4, 4).isEmpty());
        System.out.println(Range.openClosed(4, 4).isEmpty());
        System.out.println(Range.closed(4, 4).isEmpty());
    //    System.out.println(Range.open(4, 4).isEmpty());

        System.out.println(Range.closed(3, 10).lowerEndpoint());
        System.out.println(Range.open(3, 10).lowerEndpoint());
        System.out.println(Range.closed(3, 10).lowerBoundType());
        System.out.println(Range.open(3, 10).upperBoundType());
    }

    /**
     * isConnected
     */
    @Test
    public void test3(){
        System.out.println(Range.closed(3, 5).isConnected(Range.open(5, 10)));
        System.out.println(Range.closed(0, 9).isConnected(Range.closed(3, 4)));
        System.out.println(Range.closed(0, 5).isConnected(Range.closed(3, 9)));
        System.out.println(Range.open(3, 5).isConnected(Range.open(5, 10)));
        System.out.println(Range.closed(1, 5).isConnected(Range.closed(6, 10)));

    }
}
