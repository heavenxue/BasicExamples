package com.aibei.lixue.designmodeexample.bridge;

/**
 * 桥接模式
 * 将抽象部分与它的实现部分分离，使它们都可以独立地变化
 *
 * **桥接模式适合使用在需要跨越多个平台的图形和窗口系统上**
 *
 * 作者：lixue on 2017/3/9 17:24
 *
 * 优点
 *
 * 分离抽象接口及其实现部分。
 * 桥接模式有时类似于多继承方案，但是多继承方案违背了类的单一职责原则（即一个类只有一个变化的原因），复用性比较差，而且多继承结构中类的个数非常庞大，桥接模式是比多继承方案更好的解决方法。
 * 桥接模式提高了系统的可扩充性，在两个变化维度中任意扩展一个维度，都不需要修改原有系统。
 * 实现细节对客户透明，可以对用户隐藏实现细节。
 *
 * 缺点
 *
 * 桥接模式的引入会增加系统的理解与设计难度，由于聚合关联关系建立在抽象层，要求开发者针对抽象进
 * 行设计与编程。 - 桥接模式要求正确识别出系统中两个独立变化的维度，因此其使用范围具有一定的局限性。
 *
 */

public abstract class Car {
    private ITire tire;
    public Car(ITire tire){
        this.tire = tire;
    }

    public ITire getTire() {
        return tire;
    }

    public abstract String run();
}
