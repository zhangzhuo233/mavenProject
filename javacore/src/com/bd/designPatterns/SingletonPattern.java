package com.bd.designPatterns;

/**
 * @program: javacore
 * @description: 单例模式
 * @author: Mr.zhang
 * @create: 2019-08-28 12:20
 **/
public class SingletonPattern {
    public static void main(String[] args) {
        // 饿汉式
        SingletonByHungryMan instance1 = SingletonByHungryMan.getInstance();
        SingletonByHungryMan instance2 = SingletonByHungryMan.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(instance1.equals(instance2));
        // 懒汉式
        SingletonByIdler instance3 = SingletonByIdler.getInstance();
        SingletonByIdler instance4 = SingletonByIdler.getInstance();
        System.out.println(instance3 == instance4);
        System.out.println(instance3.equals(instance4));
    }
}

/**
* @Description: 饿汉式（一上来就创建对象）
* @Author: Mr.zhang
* @Date: 2019/8/28
*/
class SingletonByHungryMan {
    private static SingletonByHungryMan instance = new SingletonByHungryMan();
    // 构造私有化
    private SingletonByHungryMan() {}
    // 暴露创建实例的方法
    public static SingletonByHungryMan getInstance() {
        return instance;
    }
}

/**
* @Description:  懒汉式(用时创建对象),存在线程安全问题
* @Author: Mr.zhang
* @Date: 2019/8/28
*/
class SingletonByIdler {
    private static SingletonByIdler instance;
    // 构造私有化
    private SingletonByIdler() {}
    // 暴露创建实例的方法
    public static SingletonByIdler getInstance() {
        // 减少进入同步的次数
        if (instance == null) {
            synchronized (SingletonByIdler.class) {
                // 同步条件，防止多个线程同时进入此分支->多次实例化
                if (instance == null)
                    instance = new SingletonByIdler();
            }
        }
        return instance;
    }

}