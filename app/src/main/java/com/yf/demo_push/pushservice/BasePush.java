package com.yf.demo_push.pushservice;

import android.content.Context;
import android.text.TextUtils;

/**
 * Created by Administrator on 2017/5/31.
 * 推送的父类
 */

public abstract class BasePush implements IPush{

    private String pushName;
    private String pushKey;
    public BasePush(String pushName_, String pushKey_){
        this.pushName = pushName_;
        this.pushKey = pushKey_;
    }
    @Override
    public void register(Context context) {
        if (TextUtils.isEmpty(PushUtil.getString(context,pushKey))){
            registerPush(context);
        }else {
            PushUtil.sendRegisterBroadcast(context, pushName);
        }

    }

    protected abstract void registerPush(Context context);
}
