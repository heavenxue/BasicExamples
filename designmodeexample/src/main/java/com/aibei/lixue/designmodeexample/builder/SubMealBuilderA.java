package com.aibei.lixue.designmodeexample.builder;

/**
 * 套餐A
 *
 * 作者：lixue on 2017/3/6 12:36
 */

public class SubMealBuilderA extends MealBuilder {

    @Override
    public void buildFood() {
        meal.setFood("劲脆鸡腿堡");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("可乐");
    }
}
