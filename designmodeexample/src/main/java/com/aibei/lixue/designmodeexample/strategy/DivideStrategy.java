package com.aibei.lixue.designmodeexample.strategy;

/**
 * 作者：lixue on 2017/3/7 17:26
 */

public class DivideStrategy implements Strategy {
    @Override
    public double calc(double paramA, double paramB) {
        if (paramB == 0){
            throw new IllegalArgumentException("除数不能为0");
        }
        return paramA / paramB;
    }
}
