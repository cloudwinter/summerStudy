package com.summer.demo.ss.summerstudy.binder.custom;

import android.os.IInterface;
import android.os.RemoteException;

/**
 * 定义自定义Binder接口
 * Created by xiayundong on 2018/7/3.
 */

public interface ICustom extends IInterface {

    String descriptor = "android.app.ICustom";

    int TRANSACTION_customMethod = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);

    int customMethod() throws RemoteException;
}
