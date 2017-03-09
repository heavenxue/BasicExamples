package com.aibei.lixue.designmodeexample.iterator;

/**
 * 作者：lixue on 2017/3/9 14:55
 */

//迭代器角色（Iterator）
public interface Iterator {
    Object first();
    Object next();
    boolean hasNext();
    Object currentItem();
}

