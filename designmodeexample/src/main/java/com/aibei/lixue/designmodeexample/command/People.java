package com.aibei.lixue.designmodeexample.command;

/**
 * 人
 * 作者：lixue on 2017/3/9 16:05
 */

public class People {
    private int age;
    private String name;
    public void update(int age,String name){
        this.age = age;
        this.name = name;
    }

    public void updateAge(int age){
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "the people'age is " + age + ",the name :" + name;
    }
}
