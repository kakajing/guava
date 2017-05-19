package com.mayu.guava.primitives;

import com.google.common.primitives.Ints;
import org.junit.Test;

/**
 * 原生类型测试，感觉无需demo测试,使用的时候看下源码提供哪些发放即可
 *
 * Author 卡卡
 * Created by jing on 2017/5/19.
 */
public class PrimitivesTest {

    @Test
    public void intsTest(){
        System.out.println(Ints.compare(1, 2));
    }
}
