package com.mayu.guava.strings;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Author 卡卡
 * Created by jing on 2017/5/19.
 */
public class StringsTest {

    /**
     * Guava Strings工具类的使用，null和empty的判断与转化
     */
    @Test
    public void test(){
        System.out.println(Strings.isNullOrEmpty(""));    //true
        System.out.println(Strings.nullToEmpty(null));     //""
        System.out.println(Strings.nullToEmpty("chen"));   //chen
        System.out.println(Strings.emptyToNull(""));       //null
        System.out.println(Strings.emptyToNull("chen"));  //chen

        System.out.println(Strings.commonPrefix("aaa", "aabbb"));  //aa
        System.out.println(Strings.commonSuffix("aabb", "ccbb"));  //bb
    }

    /**
     * Strings的padStart和padEnd方法来补全字符串
     */
    @Test
    public void test2(){
        int minLenght = 4;
        System.out.println("padEndResult: " + Strings.padEnd("123", minLenght, '0'));
        System.out.println("padStartResult：" + Strings.padStart("1", 2, '0'));
    }

    /**
     * 使用Splitter类来拆分字符串
     */
    @Test
    public void test3(){
        Iterable<String> split = Splitter.onPattern("[,，]{1,}")
                .trimResults()  //移除结果字符串的前导空白和尾部空白
                .omitEmptyStrings()   //自动忽略空字符串
                .split("hello,word,,大家，共同");
        for (String iter : split) {
            System.out.println(iter);
        }
    }

    /**
     * 使用Splitter类来二次拆分
     */
    @Test
    public void test4(){
        String ss = "a=b;c=d;e=f";
        Map<String, String> split = Splitter.onPattern("[,;]{1,}")
                .withKeyValueSeparator('=')  //第二次的拆分
                .split(ss);
        for (Map.Entry<String, String> entry : split.entrySet()) {
            System.out.println(String.format("%s=%s", entry.getKey(), entry.getValue()));
        }
    }

    /**
     * 使用Joiner做字符串合并
     */
    @Test
    public void test5(){
        String join = Joiner.on(" ").join(new String[]{"hello", "world"});
        System.out.println(join);
    }

    /**
     * 使用Joiner对map合并
     */
    @Test
    public void test6(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "b");
        map.put("c", "d");
        String join = Joiner.on(",")
                .withKeyValueSeparator("=")
                .join(map);
        System.out.println(join);  //a=b,c=d
    }
}
