package com.aibei.lixue.designmodeexample.builder;

/**
 * 作者：lixue on 2017/3/6 12:45
 */

public class KFCWaiter {
    MealBuilder builder;
    public KFCWaiter(MealBuilder builder){
        this.builder = builder;
    }

    /**
     * 构建对象
     */
    public void construct(){
        builder.buildFood();
        builder.buildDrink();
    }
   }
