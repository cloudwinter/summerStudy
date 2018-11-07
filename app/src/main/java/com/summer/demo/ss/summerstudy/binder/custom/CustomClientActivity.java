package com.summer.demo.ss.summerstudy.binder.custom;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.summer.demo.ss.summerstudy.R;
import com.summer.demo.ss.summerstudy.binder.IRemoteService;

/**
 * Created by xiayundong on 2018/7/3.
 */

public class CustomClientActivity extends Activity {


    private static final String TAG = "CustomClientActivity";


    private ICustom mICustom;

    private Button mBindBut;
    private Button mUnBindBut;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        mBindBut = (Button) findViewById(R.id.btn_bind);
        mUnBindBut = (Button) findViewById(R.id.btn_unbind);
        mBindBut.setOnClickListener(mClick);
        mUnBindBut.setOnClickListener(mClick);
    }

    private View.OnClickListener mClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_bind:
                    bindRemoteService();
                    break;
                case R.id.btn_unbind:
                    unbindRemoteService();
                    break;
            }
        }
    };

    private ServiceConnection mConnecttion = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mICustom = CustomServiceNative.asInterface(service);
            try {
                int result = mICustom.customMethod();

                Log.i(TAG, "[ClientActivity] onServiceConnected customMethod" + result);

            } catch (Exception e) {

            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "[ClientActivity] onServiceDisconnected");
            mICustom = null;
        }
    };


    private void bindRemoteService() {

        Log.i(TAG, "[ClientActivity] bindRemoteService");
        Intent intent = new Intent(CustomClientActivity.this, CustomRemoteService.class);
        intent.setAction(IRemoteService.class.getName());
        bindService(intent, mConnecttion, Context.BIND_AUTO_CREATE);


    }

    private void unbindRemoteService() {
        Log.i(TAG, "[ClientActivity] unnbindRemoteService");
        unbindService(mConnecttion);
    }
}
