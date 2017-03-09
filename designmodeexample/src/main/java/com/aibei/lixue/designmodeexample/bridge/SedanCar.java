package com.aibei.lixue.designmodeexample.bridge;

/**
 * 作者：lixue on 2017/3/9 17:26
 */

public class SedanCar extends Car {
    public SedanCar(ITire tire) {
        super(tire);
    }

    @Override
    public String run() {
        return "sedancar car " + getTire().run();
    }
}
