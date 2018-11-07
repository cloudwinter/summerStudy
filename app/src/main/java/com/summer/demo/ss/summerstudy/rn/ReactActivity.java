package com.summer.demo.ss.summerstudy.rn;

import com.facebook.react.ReactPackage;

import java.util.List;

/**
 * Created by xiayundong on 2018/5/31.
 */

public class ReactActivity extends com.facebook.react.ReactActivity{


    @Override
    protected String getMainComponentName() {
        return "rn";
    }

    @Override
    protected boolean getUseDeveloperSupport() {
        return true;
    }

    @Override
    protected List<ReactPackage> getPackages() {
        return null;
    }
}
