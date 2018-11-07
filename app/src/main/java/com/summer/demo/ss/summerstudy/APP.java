package com.summer.demo.ss.summerstudy;

import android.app.Application;

import com.summer.demo.ss.summerstudy.error.AppUncaughtExceptionHandler;


/**
 * Created by xiayundong on 2018/6/1.
 */

public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppUncaughtExceptionHandler.getInstance().init(this);
    }
}
