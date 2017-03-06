package com.aibei.lixue.designmodeexample.builder;

/**
 * 建造者模式
 * 作者：lixue on 2017/3/6 12:32
 *
 * 优点：
 * * 客户端不需要知道产品的创建过程，将产品本身与产品的创建过程解耦，使得相同的创建过程可以创建不同的产品对象
 * * 用户使用不同的具体创造者创造出自己想要的不同的产品对象
 * * 增加新的创造者，无需添加或修改库代码，指挥者类针对抽象建造者类编程，系统扩展方便，符合“开闭原则”
 *
 * 缺点：
 * * 建造者模式所创建额产品大多类似，组成部分相同，如果产品间的差异性较大，则不适合创造者模式，因此适用范围收到一定的限制
 * * 如果产品内部变化复杂，可能会导致需要定义很多具体创造者类来实现这种变化，导致系统变得很庞大
 *
 * 《适用环境》
 * 需要生成的产品内部结构复杂，这些产品往往包含多个成员属性
 * 需要生成的产品对象的属性相互依赖，需要指定其生产顺序
 * 对象的创建过程独立于该对象的类。在建造者模式中引入了指挥类，将创建过程封装在指挥类中，而不在建造者类中
 * 隔离复杂对象的创建和使用，并使得相同的创建过程可以创建不同的产品
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
