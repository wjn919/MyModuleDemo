package com.wjn.commonlibrary;

import android.app.Application;
import android.content.Context;

import java.util.logging.Logger;

/**
 * Created by wjn on 2017/7/3.
 */

public class BaseApplication extends Application {
    private static BaseApplication sInstance;
    public static Context context;
    public static BaseApplication getsInstance() {
        return sInstance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        context = this.getApplicationContext();
    }
}