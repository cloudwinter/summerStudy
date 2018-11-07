package com.summer.demo.ss.summerstudy.java.singleton;

/**
 * 静态内部类
 * Created by xiayundong on 2018/11/7.
 */

public class SingletonInner {

    private SingletonInner() {

    }

    static class SingletonHolder {
        private static final SingletonInner mInstance = new SingletonInner();
    }

    public static SingletonInner getInstance() {
        return SingletonHolder.mInstance;
    }
}
