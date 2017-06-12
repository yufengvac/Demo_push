package com.yf.demo_push.pushservice.huawei;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.huawei.android.pushagent.api.PushEventReceiver;
import com.yf.demo_push.pushservice.PushUtil;

/**
 *
 *
 */

public class HuaweiPushReceiver extends PushEventReceiver {
    private static final String TAG = HuaweiPushReceiver.class.getSimpleName();
    @Override
    public void onEvent(Context context, Event event, Bundle bundle) {
        Log.e(TAG,"onEvent-->event="+event);
        String content = bundle.getString(BOUND_KEY.pushMsgKey);
        if (Event.NOTIFICATION_OPENED.equals(event)){
            PushUtil.sendClickedBroadcast(context, content, HuaweiPush.HUAWEI_PUSH_NAME);
        }
    }

    @Override
    public void onToken(Context context, String token, Bundle extras) {
        String belongId = extras.getString("belongId");
        String content = "获取token和belongId成功，token = " + token + ",belongId = " + belongId;
        Log.e(TAG,"onToken-->token="+token+",content="+content);

        if (!TextUtils.isEmpty(token)){
            PushUtil.putString(context, HuaweiPush.HUAWEI_KEY, token);
            PushUtil.sendRegisterBroadcast(context, HuaweiPush.HUAWEI_PUSH_NAME);
        }
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
            PushUtil.sendShowNotificationBroadcast(context,content, HuaweiPush.HUAWEI_PUSH_NAME);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onPushState(Context context, boolean b) {
        super.onPushState(context, b);
    }

    @Override
    public void onToken(Context context, String s) {
        super.onToken(context, s);
    }
}
