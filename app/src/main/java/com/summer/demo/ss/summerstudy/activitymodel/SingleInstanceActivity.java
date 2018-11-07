package com.summer.demo.ss.summerstudy.activitymodel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.summer.demo.ss.summerstudy.MainActivity;
import com.summer.demo.ss.summerstudy.R;

/**
 * <p>单例模式</p>
 * <p>和singleTask类似系统中只允许有一个实例存在</p>
 * <p>这个实例所处的任务栈只允许有唯一activity,即本身</p>
 * <p>singleInstance的activity启动的另一activity，新建的activity会回到启动singleInstance之前的栈顶</p>
 * <p>实验得出，不管是否设置taskAffinity都会新建一个新的任务栈</p>
 * Created by xiayundong on 2018/6/27.
 */

public class SingleInstanceActivity extends Activity {

    private static final String TAG = "SingleInstanceActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "SingleInstanceActivity onCreate taskId:" + getTaskId() + "code:" + hashCode());
        setContentView(R.layout.activity_singleinstance);
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SingleInstanceActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e(TAG, "SingleInstanceActivity onNewIntent: " );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "SingleInstanceActivity onDestroy: code:" + hashCode());
    }
}
