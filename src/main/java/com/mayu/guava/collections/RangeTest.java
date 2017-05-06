package com.mayu.guava.collections;

import com.google.common.collect.*;
import org.junit.Test;

/**
 * RangeSet用来处理一系列不连续，非空的range
 * RangeMap代表了非连续非空的range对应的集合
 *
 * Author 卡卡
 * Created by jing on 2017/5/6.
 */
public class RangeTest {

    @Test
    public void RangeSetTest(){
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1,10));
        System.out.println("rangeSet: "+rangeSet);
        rangeSet.add(Range.closed(11, 15));
        System.out.println("rangeSet: "+rangeSet);
        rangeSet.add(Range.open(15, 20));
        System.out.println("rangeSet: "+rangeSet);
        rangeSet.add(Range.openClosed(0, 0));
        System.out.println("rangeSet:"+rangeSet);
        rangeSet.remove(Range.open(5, 10));
        System.out.println("rangeSet:"+rangeSet);
    }

    @Test
    public void RangeMapTest(){

        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1, 10), "foo");
        System.out.println("rangeMap:"+rangeMap);
        rangeMap.put(Range.open(3, 6), "bar");
        System.out.println("rangeMap:"+rangeMap);
        rangeMap.put(Range.open(10, 20), "foo");
        System.out.println("rangeMap:"+rangeMap);
        rangeMap.remove(Range.closed(5,11));
        System.out.println("rangeMap:"+rangeMap);

    }
}
