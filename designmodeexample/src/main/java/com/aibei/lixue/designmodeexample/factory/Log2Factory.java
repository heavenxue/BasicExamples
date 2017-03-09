package com.aibei.lixue.designmodeexample.factory;

public class Log2Factory implements ILogFactory {
    @Override
    public ILog createFileLog() {
        return new FileLog2();
    }

    @Override
    public ILog2 createDatabaseLog() {
        return new DataBaseLog2();
    }
}
