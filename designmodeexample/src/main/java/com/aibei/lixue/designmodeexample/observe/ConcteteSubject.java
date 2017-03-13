package com.aibei.lixue.designmodeexample.observe;

/**
 * 作者：lixue on 2017/3/13 18:03
 */

public class ConcteteSubject extends SubJect {
    private String state;

    public String getState() {
        return state;
    }

    public void change(String newState){
        state = newState;
        System.out.println("主题状态为：" + state);
        //状态发生改变，通知各个观察者
        this.nodifyObservers(state);
    }
}
