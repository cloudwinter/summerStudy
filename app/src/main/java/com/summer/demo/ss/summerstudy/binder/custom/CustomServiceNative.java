package com.summer.demo.ss.summerstudy.binder.custom;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * Created by xiayundong on 2018/7/3.
 */

public abstract class CustomServiceNative extends Binder implements ICustom {

    public CustomServiceNative() {
        attachInterface(this, descriptor);
    }

    public static ICustom asInterface(IBinder obj) {
        if (obj == null) {
            return null;
        }
        ICustom iCustom = (ICustom) obj.queryLocalInterface(descriptor);
        if (iCustom != null) {
            return iCustom;
        } else {
            return new CustomServiceProxy(obj);
        }
    }

    @Override
    public IBinder asBinder() {
        return this;
    }

    @Override
    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case INTERFACE_TRANSACTION: {
                reply.writeString(descriptor);
                return true;
            }
            case TRANSACTION_customMethod: {
                data.enforceInterface(descriptor);
                int _result = this.customMethod();
                reply.writeNoException();
                reply.writeInt(_result);
                return true;
            }
        }
        return super.onTransact(code, data, reply, flags);
    }


}

class CustomServiceProxy implements ICustom {

    private IBinder mRemote;

    public CustomServiceProxy(IBinder remote) {
        this.mRemote = remote;
    }


    @Override
    public int customMethod() throws RemoteException {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int _result;
        try {
            _data.writeInterfaceToken(descriptor);
            mRemote.transact(ICustom.TRANSACTION_customMethod, _data, _reply, 0);
            _reply.readException();
            _result = _reply.readInt();
        } finally {
            _reply.recycle();
            _data.recycle();
        }
        return _result;
    }

    @Override
    public IBinder asBinder() {
        return mRemote;
    }
}
