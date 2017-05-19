package com.mayu.guava.strings;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * 字符串处理
 *
 * Author 卡卡
 * Created by jing on 2017/5/19.
 */
public class StrTest {

    /**
     * 将数组转list，并且去除掉null字段
     * @param args
     */
    public static void main(String[] args) {
        Joiner joiner = Joiner.on(", ").skipNulls();
        String[] strArr = {"test", null, "test2", "test3"};
        Lists.newArrayList(joiner.join(strArr));
        System.out.println(JSON.toJSONString(Lists.newArrayList(joiner.join(strArr))));
    }
}
