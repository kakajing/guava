package com.mayu.guava.rangs;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Range;
import com.mayu.guava.Person;
import org.junit.Test;

import javax.annotation.Nullable;

/**
 * Author 卡卡
 * Created by jing on 2017/5/19.
 */
public class RangeTest {
    @Test
    public void test(){
        //创建一个指定范围的区间
        //包括开始和结束值
        Range<Integer> range = Range.closed(1, 10);
        //不包括开始和结束值
        Range<Integer> open = Range.open(1, 10);

        System.out.println(range.contains(5));
        System.out.println(range.contains(10));
        System.out.println(range.contains(1));

        System.out.println(open.contains(1));
        System.out.println(open.contains(5));
        System.out.println(open.contains(10));
    }

    @Test
    public void testPredicate(){
        Person person1 = new Person("test1", 10);
        Person person2 = new Person("test2", 20);
        Person person3 = new Person("test3", 30);

        //通过Range和Function创建一个Predicate，根据Range对数据进行过滤判断
        Range<Integer> ageRange = Range.closed(20, 25);
        Function<Person, Integer> ageFunction = new Function<Person, Integer>() {
            @Nullable
            @Override
            public Integer apply(@Nullable Person person) {
                return person.getAge();
            }
        };

        Predicate<Person> predicate = Predicates.compose(ageRange, ageFunction);

        System.out.println(predicate.apply(person1));
        System.out.println(predicate.apply(person2));
        System.out.println(predicate.apply(person3));
    }

}
