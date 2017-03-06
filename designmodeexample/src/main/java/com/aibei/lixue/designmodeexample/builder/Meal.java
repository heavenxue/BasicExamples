package com.aibei.lixue.designmodeexample.builder;

/**
 * 饭，抽象类
 *
 * 作者：lixue on 2017/3/6 11:56
 */

public class Meal {
    private String drink;
    private String food;
    public Meal(){}
    public void setDrink(String drink){
     this.drink = drink;
    }
    public void setFood(String food){
        this.food = food;
    }
    public String getDrink(){
        return this.drink;
    }
    public String getFood(){
        return this.food;
    }
}
