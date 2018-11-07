package com.summer.demo.ss.summerstudy.activitymodel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.summer.demo.ss.summerstudy.R;

/**
 * <p>和standard类似可以无限创建新的activity</p>
 * <p>和standard一样在默认的栈中</p>
 * <p>如果当前栈顶已经有一个相同类型activity,则不会重新创建，而是走onNewIntent</p>
 * <p>使用场景：如引导页，或者搜索页，etc</p>
 * Created by xiayundong on 2018/6/27.
 */

public class SingleTopActivity extends Activity {

    private static final String TAG = "SingleTopActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "SingleTopActivity onCreate taskId:" + getTaskId() + "code:" + hashCode());
        setContentView(R.layout.activity_singletop);

        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SingleTopActivity.this, SingleInstanceActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e(TAG, "SingleTopActivity onNewIntent");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "SingleTopActivity onDestroy: code:" + hashCode());
    }
}
