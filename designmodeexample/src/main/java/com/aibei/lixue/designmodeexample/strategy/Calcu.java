package com.aibei.lixue.designmodeexample.strategy;

/**
 * 上下文环境的实现
 * 作者：lixue on 2017/3/7 17:29
 *
 * 策略模式主要用来分离算法，根据相同的行为抽象来做不同的具体策略实现。（把算法的责任和算法本身分开，委托给对象管理）

 * 通过以上也可以看出策略模式的优缺点：

 * 优点：

 * 结构清晰明了、使用简单直观。
 * 耦合度相对而言较低，扩展方便。
 * 操作封装也更为彻底，数据更为安全。
 * 使用策略模式可以避免使用多重条件转移语句。
 *
 * 缺点：

 * 随着策略的增加，子类也会变得繁多。
 * 客户端必须知道所有的策略类，并自行决定使用哪一个策略类。
 *
 * 适用环境
 *
 * 如果在一个系统里面有许多类，它们之间的区别仅在于它们的行为，那么使用策略模式可以动态地让一个对象在许多行为中选择一种行为。
 * 一个系统需要动态地在几种算法中选择一种。
 * 如果一个对象有很多的行为，如果不用恰当的模式，这些行为就只好使用多重的条件选择语句来实现。
 * 不希望客户端知道复杂的、与算法相关的数据结构，在具体策略类中封装算法和相关的数据结构，提高算法的保密性与安全性。
 */

public class Calcu {
    private Strategy strategy;
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public double calc(double paramA, double paramB) {
        // TODO Auto-generated method stub
        // doing something
        if (this.strategy == null) {
            throw new IllegalStateException("你还没有设置计算的策略");
        }
        return this.strategy.calc(paramA, paramB);
    }

    //执行方法
    public static double calc(Strategy strategy, double paramA, double paramB) {
        Calcu calc = new Calcu();
        calc.setStrategy(strategy);
        return calc.calc(paramA, paramB);
    }
}

