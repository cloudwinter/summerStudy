package com.summer.demo.ss.summerstudy.activitymodel;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.summer.demo.ss.summerstudy.R;

/**
 * <p>默认的启动的模式，每次都会创建一个新的activity</p>
 * <p>新建的activity还是在默认的task栈中</p>
 * Created by xiayundong on 2018/6/27.
 */

public class StandardActivity extends Activity {

    private static final String TAG = "StandardActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "StandardActivity onCreate  taskId:" + getTaskId() + " code:" + hashCode());
        setContentView(R.layout.activity_standard);

        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(StandardActivity.this, SingleTopActivity.class);
                startActivity(intent);
//                intent.setAction("android.intent.action.SINGLETOP");
//                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "StandardActivity onDestroy: code:" + hashCode());
    }
}
