package com.aibei.lixue.designmodeexample.strategy;

/**
 * 作者：lixue on 2017/3/7 17:23
 */

public class AddStrategy implements Strategy {
    @Override
    public double calc(double paramA, double paramB) {
        return paramA + paramB;
    }
}
