package com.aibei.lixue.designmodeexample.factory;

/**
 * 作者：lixue on 2017/3/6 15:36
 */

public class DataBaseLog implements ILog2 {
    @Override
    public void outLog() {
        System.out.println("database's log this is ........");
    }
}
