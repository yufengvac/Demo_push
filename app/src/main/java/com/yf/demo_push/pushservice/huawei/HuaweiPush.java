package com.yf.demo_push.pushservice.huawei;

import android.content.Context;

import com.huawei.android.pushagent.api.PushManager;
import com.yf.demo_push.pushservice.BasePush;
import com.yf.demo_push.pushservice.PushShareUtil;

/**
 * Created by Administrator on 2017/5/31.
 *
 */

public class HuaweiPush extends BasePush{

    private static final String HUAWEI_KEY ="huawei_key";

    @Override
    protected void registerPush(Context context) {
        PushManager.requestToken(context);
    }

    public static void unRegisterPush(Context context){
        String token = PushShareUtil.getString(context.getApplicationContext(),HUAWEI_KEY);
        if (token != null){
            PushManager.deregisterToken(context , token);
            PushShareUtil.putString(context, HUAWEI_KEY, null);
        }
    }
}
