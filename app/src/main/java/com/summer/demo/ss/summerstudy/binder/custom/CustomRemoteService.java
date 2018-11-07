package com.summer.demo.ss.summerstudy.binder.custom;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * 自定义的远程服务端
 * 使用非aidl的方式实现两个进程间的Binder通信
 * Created by xiayundong on 2018/7/3.
 */

public class CustomRemoteService extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return customService;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    CustomServiceNative customService = new CustomServiceNative() {
        @Override
        public int customMethod() throws RemoteException {
            return 10;
        }
    };
}
