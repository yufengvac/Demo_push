package com.yf.demo_push.pushservice.huawei;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.huawei.android.pushagent.api.PushEventReceiver;

import java.io.UnsupportedEncodingException;


/**
 * Created by Administrator on 2017/5/31.
 *
 */

public class HuaweiPushReceiver extends PushEventReceiver {
    private static final String TAG = HuaweiPushReceiver.class.getSimpleName();

    @Override
    public void onEvent(Context context, Event event, Bundle bundle) {
        Log.e(TAG,"onEvent-->event="+event);
    }

    @Override
    public void onToken(Context context, String token, Bundle extras) {
        String belongId = extras.getString("belongId");
        String content = "获取token和belongId成功，token = " + token + ",belongId = " + belongId;
        Log.e(TAG,"onToken-->token="+token+",content="+content);
    }

    @Override
    public boolean onPushMsg(Context context, byte[] bytes, Bundle bundle) {
        return super.onPushMsg(context, bytes, bundle);
    }

    @Override
    public void onPushMsg(Context context, byte[] bytes, String s) {
        try{
            String content = new String(bytes,"UTF-8");
            Log.e(TAG,"onPushMsg--->s="+s+",content="+content);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onPushState(Context context, boolean b) {
        Log.e(TAG,"onPushState--->b="+b);
    }

    @Override
    public void onToken(Context context, String s) {
        Log.e(TAG,"onToken-->s="+s);
    }

    @Override
    protected void a(Context context, Intent intent) throws UnsupportedEncodingException {

    }
}
