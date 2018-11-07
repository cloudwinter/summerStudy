// IRemoteService.aidl
package com.summer.demo.ss.summerstudy.binder;
import com.summer.demo.ss.summerstudy.binder.MyData;
// Declare any non-default types here with import statements

interface IRemoteService {
//    /**
//     * Demonstrates some basic types that you can use as parameters
//     * and return values in AIDL.
//     */
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);

    int getPid();

    MyData getMyData();
}
