package com.aibei.lixue.designmodeexample.bridge;

/**
 * 作者：lixue on 2017/3/9 17:28
 */

public class RainyTire implements ITire {
    @Override
    public String run() {
        return "run on the rainy road.";
    }
}
