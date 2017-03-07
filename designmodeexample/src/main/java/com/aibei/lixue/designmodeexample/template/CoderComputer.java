package com.aibei.lixue.designmodeexample.template;

/**
 * 作者：lixue on 2017/3/7 16:46
 */

public class CoderComputer extends AbstractComputer {
    @Override
    protected void login() {
        System.out.println("码农只需要进行用户和密码验证就可以了");
    }
}
