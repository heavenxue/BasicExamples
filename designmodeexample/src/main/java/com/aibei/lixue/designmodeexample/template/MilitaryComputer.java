package com.aibei.lixue.designmodeexample.template;

/**
 * 军用计算机
 * 作者：lixue on 2017/3/7 16:47
 */

public class MilitaryComputer extends AbstractComputer {
    @Override
    protected void checkHardware() {
        super.checkHardware();
        System.out.println("检查硬件防火墙");
    }

    @Override
    protected void login() {
        System.out.println("进行指纹之别等复杂的用户验证");
    }
}
