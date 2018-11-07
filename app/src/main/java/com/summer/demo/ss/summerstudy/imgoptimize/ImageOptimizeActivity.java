package com.summer.demo.ss.summerstudy.imgoptimize;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * 图片优化方案处理
 * <p>
 * 1：图片本身的优化处理
 * --1.1：比例压缩法
 * --1.2：质量压缩法
 * 2：图片存储的优化处理
 * --2.1：自定义缓存方案，使用LRUCache设置三层缓存方式
 * --2.2：使用市面的的第三方空间，imageLoader,fesco,等
 * </p>
 * Created by xiayundong on 2018/8/28.
 */

public class ImageOptimizeActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
