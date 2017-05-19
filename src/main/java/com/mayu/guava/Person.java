package com.mayu.guava;

import com.google.common.base.MoreObjects;

/**
 * Author 卡卡
 * Created by jing on 2017/5/19.
 */
public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(){}


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this.getClass().getName())
                .addValue(this.getName())
                .addValue(this.getAge())
                .toString();
    }

    public void save(String name, int age){
        this.name = name;
        this.age = age;
    }
}
