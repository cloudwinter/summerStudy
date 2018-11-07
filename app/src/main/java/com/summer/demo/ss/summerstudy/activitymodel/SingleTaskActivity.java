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
 * <p>singTask只允许系统中只有一个实例</p>
 * <p>如果设置taskAffinity，那么就会重新生成一个新的任务栈，如果没有就会在默认的任务栈中</p>
 *
 * <p>1.如果是同一个应用中，没有设置taskAffinity</p>
 *      如果没有实例化，会创建一个，放在栈顶
 *      如果已经实例化，会重新调用onNewIntent(),同时会把它上面的activity全部finish掉，让它成为栈顶
 *
 * <p>2.如果是同一个应用中，设置了taskAffinity</p>
 *      如果没有实例化，会创建一个新的任务栈，并置于栈的根部（root）
 *
 *
 *<p>3.如果是不同的应用</p>
 *      如果当前的应用没有启动，则将当前的activity当栈的根部启动
 *      如果当前的应用已经启动，则将当前的activity放在栈顶
 *
 *<p>4.使用场景，例如：用于首页</p>
 * Created by xiayundong on 2018/6/27.
 */

public class SingleTaskActivity extends Activity {

    private static final String TAG = "SingleTaskActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "SingleTaskActivity onCreate taskId:" + getTaskId() + " code:" + hashCode());
        setContentView(R.layout.activity_singletask);
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SingleTaskActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e(TAG, "SingleTaskActivity onNewIntent: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "SingleTaskActivity onDestroy: code:" + hashCode());
    }
}
