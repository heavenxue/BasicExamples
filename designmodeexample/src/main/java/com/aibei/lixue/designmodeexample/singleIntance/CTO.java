package com.aibei.lixue.designmodeexample.singleIntance;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：lixue on 2017/3/3 15:30
 *
 * 单例模式只包含一个单例角色：
 * 在单例类的内部实现只生成一个实例，同时它提供一个静态的工厂方法，让客户可以使用它的唯一实例；
 * 为了防止在外部对其实例化，将其构造函数设计为私有。
 *
 * 优点：
 * * 提供了对唯一实例的受控访问
 * * 由于在系统中只存在这一个对象，因此节约了系统资源，对于一些需要频繁创建和销毁的对象，单例模式无疑提高了系统性能
 * * 允许可变数目的实例。我们可以基于单例模式进行扩展，使用与单例控制相似的方法来获得指定个数的对象实例
 * 缺点：
 * * 由于单例模式没有抽象层，所以很难扩展
 * * 单例类的职责过大，在一定程度上违背了“单一职责原则”
 * * 滥用单例带来一些负面问题：
 *      如为了节省资源共享数据库链接池设置成单例模式，访问共享连接池对象的程序过多，可能会造成溢出
 *      现在java有自动回收机制，如果实例化的对象长期不用可能被回收，下次利用的时候又重新创建对象，可能会导致对象状态的丢失
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
