package com.aibei.lixue.designmodeexample.template;

/**
 * 抽象的computer
 * 作者：lixue on 2017/3/7 16:43
 *
 * 模板方法是定义一个操作中的算法的框架，而将一些步骤延迟到子类中。
 * 使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
 *
 * 优点

 * 封装不变部分，扩展可变部分
 * 提取公共部分代码，便于维护


 * 缺点
 *
 * 模板方法会带来代码阅读的难度，会让心觉得难以理解。
 *
 */

public abstract class AbstractComputer {
    protected void powerOn() {
        System.out.println("开启电源");
    }

    protected void checkHardware() {
        System.out.println("硬件检查");
    }

    protected void loadOS() {
        System.out.println("载入操作系统");
    }

    protected void login() {
        System.out.println("小白的电脑无验证，直接进入系统");
    }

    /**
     * 启动电脑方法, 步骤固定为开启电源、系统检查、加载操作系统、用户登录。该方法为final， 防止算法框架被覆写.
     */
    public final void startUp() {
        System.out.println("------ 开机 START ------");
        powerOn();
        checkHardware();
        loadOS();
        login();
        System.out.println("------ 开机 END ------");
    }
}
