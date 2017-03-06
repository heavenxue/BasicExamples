package com.aibei.lixue.designmodeexample.factory;

/**
 * 作者：lixue on 2017/3/6 15:35
 */

public class FileLog implements ILog {
    @Override
    public String writeLog() {
        return "file's log this is ...........";
    }
}
