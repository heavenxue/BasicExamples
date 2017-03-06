package com.aibei.lixue.designmodeexample.factory;

/**
 * 作者：lixue on 2017/3/6 15:37
 */

public interface ILogFactory {
    ILog createFileLog();
    ILog createDatabaseLog();

}
