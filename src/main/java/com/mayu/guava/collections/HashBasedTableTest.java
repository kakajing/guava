package com.mayu.guava.collections;

import com.google.common.collect.HashBasedTable;
import org.junit.Test;

/**
 * Author 卡卡
 * Created by jing on 2017/5/6.
 */
public class HashBasedTableTest {

    @Test
    public void test(){
        HashBasedTable<String, String, String> table = HashBasedTable.create(2, 2);
        table.put("one", "name", "testOne");
        table.put("one", "age", "10");
        table.put("two", "name", "testTwo");
        table.put("two", "age", "20");

        System.out.println(table);
    }
}
