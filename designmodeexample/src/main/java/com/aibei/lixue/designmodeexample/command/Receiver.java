package com.aibei.lixue.designmodeexample.command;

/**
 * 命令的接收者
 *
 * 所有真正的操作，比如执行的命令的具体操作都在这个类里执行
 *
 * 作者：lixue on 2017/3/9 15:44
 */

public class Receiver {
    People people;
    public Receiver(People people){
        this.people = people;
    }

    public void action(int age,String name){
        people.update(age,name);
        System.out.println("接收者正在进行动作...");
    }

    public void action2(int age){
        people.updateAge(age);
        System.out.println("接收者正在进行动作2...");
    }
}
