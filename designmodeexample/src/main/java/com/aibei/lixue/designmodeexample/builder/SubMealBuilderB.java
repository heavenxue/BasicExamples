package com.aibei.lixue.designmodeexample.builder;

/**
 * 作者：lixue on 2017/3/6 12:44
 */

public class SubMealBuilderB extends MealBuilder {

    @Override
    public void buildFood() {
        meal.setFood("奥尔良鸡腿堡");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("橙汁");
    }
}
