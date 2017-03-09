package com.aibei.lixue.designmodeexample.iterator;


/**
 * 容器觉色
 * 作者：lixue on 2017/3/9 14:46
 */

public interface IContanier {
    void add(Object obj);
    void remove(Object obj);
    Iterator createIterator();
}
