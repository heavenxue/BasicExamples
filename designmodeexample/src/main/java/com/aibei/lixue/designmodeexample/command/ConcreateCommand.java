package com.aibei.lixue.designmodeexample.command;

/**
 * 命令模式
 *
 * 命令模式的本质是对命令进行封装，将发出命令的责任和执行命令的责任分割开。
 *
 * 作者：lixue on 2017/3/9 15:43
 *
 * 优点：
 *
 * 降低系统的耦合度。
 * 新的命令可以很容易地加入到系统中。
 * 可以比较容易地设计一个命令队列和宏命令（组合命令）。
 * 可以方便地实现对请求的Undo和Redo。
 *
 * 缺点：
 * 使用命令模式可能会导致某些系统有过多的具体命令类。因为针对每一个命令都需要设计一个具体命令类，
 * 因此某些系统可能需要大量具体命令类，这将影响命令模式的使用。
 *
 *
 */

public class ConcreateCommand implements  ICommand {
    private Receiver receiver;

    public ConcreateCommand(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void excute() {
        System.out.println("命令正在执行...");
        receiver.action(18,"ruby");
    }
}
