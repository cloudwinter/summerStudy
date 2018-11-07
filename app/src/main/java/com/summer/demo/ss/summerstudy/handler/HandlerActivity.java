package com.summer.demo.ss.summerstudy.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.summer.demo.ss.summerstudy.R;

/**
 * 了解handler的使用和原理、源码分析
 * <p>
 * <p>场景1：定时更新UI</p>
 * <P>场景2：两个线程之间互相更新</P>
 * <p>
 * <p>
 * <p>使用描述：
 * 1：handler创建时如果没有传looper就会获取当前线程中TLS的looper对象</br>
 * 2：如果构造是传了looper就使用传递额looper
 * <p>
 * <p>原理：
 * 1：handler发送msg到messageQueue<br>
 * 2：looper不断循环，从messageQueue中获取msg<br>
 * 3：根据当前msg的target调用handleMessage(run--->callback--handlerMessage)
 * </p>
 * Created by xiayundong on 2018/10/22.
 */

public class HandlerActivity extends Activity {


    private TextView mHandlerTextView;
    //子线程和子线程的handler
    private HandlerThread mHandlerThread = new HandlerThread("handler-thread");
    private Handler mTHandler;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        mHandlerTextView = (TextView) findViewById(R.id.tv_handler);
        findViewById(R.id.btn_handler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // 模拟网络请求
                            Thread.sleep(2000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mHandler.sendMessage(Message.obtain(mHandler, 1));
                    }
                }).start();
            }
        });


        // ui线程中执行view.post或者handler.post都是等界面绘制完成之后才会发送消息到messageQueue
        mHandlerTextView.post(new Runnable() {
            @Override
            public void run() {
                mHandlerTextView.setText("handler post run");
            }
        });

        mHandlerThread.start();
        mTHandler = new Handler(mHandlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 2) {
                    // 处理其他操作
                }
            }
        };
        mThread2.start();

    }

    /**
     * 子线程2
     */
    private Thread mThread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(3000L);
                // 处理耗时操作
                //mTHandler.sendMessage(new Message(2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                mHandlerTextView.setText("handler operated");
            }
        }
    };


}
