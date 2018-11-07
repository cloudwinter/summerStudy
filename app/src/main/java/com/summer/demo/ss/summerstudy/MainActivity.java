package com.summer.demo.ss.summerstudy;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.summer.demo.ss.summerstudy.binder.RemoteService;
import com.summer.demo.ss.summerstudy.handler.HandlerActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "MainActivity onCreate: getTaskid:" + getTaskId() + " code:" + hashCode());
        setContentView(R.layout.activity_main);
        findViewById(R.id.but_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog();
                jumpToActivity();
                jumpToService();

            }
        });
    }

    private void jumpToActivity() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, HandlerActivity.class);
        startActivity(intent);
    }

    private void jumpToService() {
        Intent intent = new Intent();
        // 如果TargetSDK大于21之后不可以再用action了
        intent.setClass(MainActivity.this, RemoteService.class);
        startService(intent);
    }

    private void createDialog() {
        Dialog dialog = new Dialog(MainActivity.this.getApplication());
        dialog.setContentView(R.layout.dialog_view);
        dialog.show();


    }


}
