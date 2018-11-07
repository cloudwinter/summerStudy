package com.summer.demo.ss.summerstudy.java.singleton;

/**
 * android使用的一种单例模式，其实是懒汉模式的扩展
 * 扩展性更好，方便初始化时业务处理和扩展
 * Created by xiayundong on 2018/11/7.
 */

public class SingletonAndroid {

    private SingletonAndroid() {

    }

    private static final SingletonLazy<SingletonAndroid> mDefault = new SingletonLazy<SingletonAndroid>() {
        @Override
        protected SingletonAndroid create() {
            return new SingletonAndroid();
        }
    };

    public SingletonAndroid getInstance() {
        return mDefault.get();
    }
}


abstract class SingletonLazy<T> {

    private T mInstatnce;

    protected abstract T create();

    public T get() {
        synchronized (this) {
            if (mInstatnce == null) {
                mInstatnce = create();
            }
            return mInstatnce;
        }
    }
}
