package com.aibei.lixue.designmodeexample.proxy;

/**
 * 具体对象角色
 * 作者：lixue on 2017/3/7 18:06
 */

public class RealSubject extends Subject {
    @Override
    public String request() {
        //一些操作
        return "具体对象角色做了一些请求";
    }
}
