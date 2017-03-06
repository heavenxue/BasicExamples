package com.aibei.lixue.designmodeexample.builder;

/**
 * 作者：lixue on 2017/3/6 12:32
 */

public abstract class MealBuilder {
    public Meal meal = new Meal();
    public MealBuilder(){}
    public abstract void buildFood();
    public abstract void buildDrink();
    public Meal getMeal(){
        return meal;
    }
}
