package com.aibei.lixue.designmodeexample.command;

/**
 * 调用者
 * 作者：lixue on 2017/3/9 15:47
 */

public class Invoker {
    private ICommand command;
    public Invoker(ICommand command){
        this.command = command;
    }

    public void call(){
        System.out.println("invoker calling...");
        command.excute();
    }
}
