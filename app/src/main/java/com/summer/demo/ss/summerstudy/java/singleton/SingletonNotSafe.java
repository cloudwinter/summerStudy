package com.summer.demo.ss.summerstudy.java.singleton;

/**
 * 单线程使用，非线程安全模式
 * Created by xiayundong on 2018/11/7.
 */

public class SingletonNotSafe {

    private static SingletonNotSafe sSingletonNotSafe;

    private SingletonNotSafe() {
    }

    public static SingletonNotSafe getInstance() {
        if (sSingletonNotSafe == null) {
            sSingletonNotSafe = new SingletonNotSafe();
        }
        return sSingletonNotSafe;
    }
}
