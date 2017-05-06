package com.mayu.guava.basic;

import com.google.common.base.Preconditions;
import org.junit.Test;

/**
 * 前置判断，非预期则抛异常
 * 违反方法契约（包括方法所使用的对象或外部数据状态）时抛出UncheckedException，
 * 其定义方法的可用性范畴；而方法因为不可控原因无法履行契约，则抛出CheckedException
 *
 * 个人：一般提供出去的方法，都有其方法自身的约定，未按此方法约定调用的则视为校验不通过，
 * 小到一个方法，大到一个接口都应该这样
 *
 * Author 卡卡
 * Created by jing on 2017/5/4.
 */
public class PreconditionsTest {

    @Test
    public void test(){
        Object obj = null;

        String str = "555";
        System.out.println(Preconditions.checkNotNull(str));
    }
}
