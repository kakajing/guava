package com.mayu.guava;

import com.google.common.primitives.Ints;

import java.util.Comparator;

/**
 * person比较器 实现 guava Comparator 接口
 *
 * Author 卡卡
 * Created by jing on 2017/5/19.
 */
public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Ints.compare(o1.getAge(), o2.getAge());
    }
}
