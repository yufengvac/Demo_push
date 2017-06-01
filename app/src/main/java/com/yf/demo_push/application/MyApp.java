package com.yf.demo_push.application;

import android.app.Application;
import android.util.Log;

import com.yf.demo_push.pushservice.PushFactory;

/**
 * Created by Administrator on 2017/5/31.
 *
 */

public class MyApp extends Application {
    private static final String TAG = MyApp.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG,"onCreate");
        PushFactory.init(this);
        PushFactory.getInstance().register(this);
    }
}
