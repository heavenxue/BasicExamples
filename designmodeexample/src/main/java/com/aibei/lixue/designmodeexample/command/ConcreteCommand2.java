package com.aibei.lixue.designmodeexample.command;

/**
 * 作者：lixue on 2017/3/9 16:29
 */

public class ConcreteCommand2 implements ICommand {
    Receiver receiver ;

    public ConcreteCommand2(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void excute() {
        receiver.action2(39);
    }
}
