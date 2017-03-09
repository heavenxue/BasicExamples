package com.aibei.lixue.designmodeexample.bridge;

/**
 * 桥接模式
 *
 * **桥接模式适合使用在需要跨越多个平台的图形和窗口系统上**
 *
 * 作者：lixue on 2017/3/9 17:24
 */

public abstract class Car {
    private ITire tire;
    public Car(ITire tire){
        this.tire = tire;
    }

    public ITire getTire() {
        return tire;
    }

    public abstract String run();
}
