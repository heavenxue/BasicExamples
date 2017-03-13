package com.aibei.lixue.designmodeexample.observe;

/**
 * 作者：lixue on 2017/3/13 18:04
 */

public class ConcteteObserve implements Observer {
    //观察者的状态
    private String observerState;

    @Override
    public void update(String status) {
        /**
         * 更新观察者的状态，使其与目标的状态保持一致
         */
        observerState = status;
        System.out.println("状态为：" + observerState);
    }
}
