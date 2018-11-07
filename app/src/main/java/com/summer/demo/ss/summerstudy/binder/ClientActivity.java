package com.summer.demo.ss.summerstudy.binder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.summer.demo.ss.summerstudy.R;

/**
 * Created by xiayundong on 2018/6/23.
 */

public class ClientActivity extends Activity {

    private static final String TAG = "ClientActivity";

    private IRemoteService mRemoteService;

    private Button mBindBut;
    private Button mUnBindBut;
    private Button mStartBut;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e(TAG, "[ClientActivity] onCreate");

        setContentView(R.layout.activity_client);
        mBindBut = (Button) findViewById(R.id.btn_bind);
        mUnBindBut = (Button) findViewById(R.id.btn_unbind);
        mStartBut = (Button) findViewById(R.id.btn_start);
        mBindBut.setOnClickListener(mClick);
        mUnBindBut.setOnClickListener(mClick);
        mStartBut.setOnClickListener(mClick);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "[ClientActivity] onDestroy");
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
                case R.id.btn_start:
                    Intent intent = new Intent(ClientActivity.this, RemoteService.class);
                    startService(intent);
                    break;
            }
        }
    };

    private ServiceConnection mConnecttion = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mRemoteService = IRemoteService.Stub.asInterface(service);
            String pidInfo = null;
            try {
                MyData myData = mRemoteService.getMyData();
                pidInfo = "pid=" + mRemoteService.getPid() +
                        ", data1 = " + myData.getData1() +
                        ", data2=" + myData.getData2();

                Log.i(TAG, "[ClientActivity] onServiceConnected " + pidInfo);

            } catch (Exception e) {

            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "[ClientActivity] onServiceDisconnected");
            mRemoteService = null;
        }
    };

    private void bindRemoteService() {

        Log.i(TAG, "[ClientActivity] bindRemoteService");
        Intent intent = new Intent(ClientActivity.this, RemoteService.class);
        intent.setAction(IRemoteService.class.getName());
        bindService(intent, mConnecttion, Context.BIND_AUTO_CREATE);


    }

    private void unbindRemoteService() {
        Log.i(TAG, "[ClientActivity] unnbindRemoteService");
        unbindService(mConnecttion);
    }

}
