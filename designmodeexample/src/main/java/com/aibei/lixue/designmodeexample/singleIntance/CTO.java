package com.aibei.lixue.designmodeexample.singleIntance;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：lixue on 2017/3/3 15:30
 *
 * 单例模式只包含一个单例角色：
 * 在单例类的内部实现只生成一个实例，同时它提供一个静态的工厂方法，让客户可以使用它的唯一实例；
 * 为了防止在外部对其实例化，将其构造函数设计为私有。
 */

public class CTO {
    private static CTO instance;
    private CTO(){}

    /**方法一
     * 最简单的单利模式实现
     * 单例模式 3个要点：
     * 1）某个类有且只有一个实例，比如数据库中的主键，不能重复
     * 2）自行创建这个实例
     * 3）自行向整个系统提供这个实例
     * @return
     */
    public static CTO getInstance(){
        if (instance == null){
            instance = new CTO();
        }
        return instance;
    }

    /**
     * 方式二、double-check，
     * 避免并发时创建了多个实例, 该方式不能完全避免并发带来的破坏.
     * @return
     */
    public static CTO getInstance2(){
        if (instance == null){
            synchronized (CTO.class){
                if (instance == null)
                    instance = new CTO();
            }
        }
        return instance;
    }

    /**
     * 方法三
     * 在第一次加载SingletonHolder时初始化一次onlyInstance对象, 保证唯一性, 也延迟了单例的实例化,
     * 如果该单例比较耗资源可以使用这种模式.
     * @return
     */
    public static CTO getInstanceFromHolder(){
        return CTOHolder.onlyInstance;
    }

    private static class CTOHolder{
        private static final CTO onlyInstance = new CTO();
    }

    /**
     *  方式四 : 枚举单例, 线程安全
     * @author mrsimple
     *
     */
    enum SingletonEnum {
        INSTANCE;
        public void doSomething() {
            System.out.println("do sth.");
        }
    }

    /**
     * 方式五
     * 注册到容器, 根据key获取对象.一般都会有多种相同属性类型的对象会注册到一个map中
     * instance容器
     */
    private static Map<String,CTO> objMap = new HashMap<String,CTO>();
    /**
     * 注册对象到map中
     * @param key
     * @param instance
     */
    public static void registerService(String key, CTO instance) {
        if (!objMap.containsKey(key) ) {
            objMap.put(key, instance) ;
        }
    }

    /**
     * 根据key获取对象
     * @param key
     * @return
     */
    public static CTO getService(String key) {
        return objMap.get(key) ;
    }
}
