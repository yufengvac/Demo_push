package com.yf.demo_push.pushservice;

import android.content.Context;

/**
 * Created by Administrator on 2017/5/31.
 * 推送的父类
 */

public abstract class BasePush implements IPush{
    @Override
    public void register(Context context) {
        registerPush(context);
    }

    protected abstract void registerPush(Context context);
}
