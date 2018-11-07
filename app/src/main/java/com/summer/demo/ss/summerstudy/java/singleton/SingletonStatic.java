package com.summer.demo.ss.summerstudy.java.singleton;

/**
 * 饿汉式，使用静态初始化变量
 * 因为只会在类加载是加载一次，所以线程安全，缺点是初始化就需要加载
 * Created by xiayundong on 2018/11/7.
 */

public class SingletonStatic {

    private static SingletonStatic sInstance = new SingletonStatic();

    private SingletonStatic() {

    }

    public static SingletonStatic getInstance() {
        return sInstance;
    }
}
