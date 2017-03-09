package com.aibei.lixue.designmodeexample.bridge;

/**
 * 作者：lixue on 2017/3/9 17:25
 */

public class RancingCar extends Car {
    public RancingCar(ITire tire) {
        super(tire);
    }

    @Override
    public String run() {
        return "rancing car " + getTire().run();
    }
}
