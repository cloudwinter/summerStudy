package com.summer.demo.ss.summerstudy.java.singleton;

/**
 * 线程安全，懒汉式，使用同步锁，
 */

public class SingletonSafe {

    private static SingletonSafe sInstance;

    private SingletonSafe() {

    }

    /**
     * 缺点，每次使用都得获取锁耗时
     *
     * @return
     */
    public static SingletonSafe getInstance1() {
        synchronized (SingletonSafe.class) {
            if (sInstance == null) {
                sInstance = new SingletonSafe();
            }
            return sInstance;
        }
    }

    /**
     * 改用双重验证
     *
     * @return
     */
    public static SingletonSafe getInstance2() {
        if (sInstance == null) {
            synchronized (SingletonSafe.class) {
                if (sInstance == null) {
                    sInstance = new SingletonSafe();
                }
            }
        }
        return sInstance;
    }


}
