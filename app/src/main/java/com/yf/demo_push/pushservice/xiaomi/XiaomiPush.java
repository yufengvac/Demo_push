package com.yf.demo_push.pushservice.xiaomi;

import android.content.Context;

import com.xiaomi.mipush.sdk.MiPushClient;
import com.yf.demo_push.pushservice.BasePush;
import com.yf.demo_push.pushservice.PushShareUtil;

/**
 * Created by Administrator on 2017/5/31.
 *
 */

public class XiaomiPush extends BasePush{

    private static final String APP_ID = "2882303761517582471";
    private static final String APP_KEY = "5491758253471";
    public static final String XIAOMI_KEY = "xiaomi_key";

    @Override
    protected void registerPush(Context context) {
        MiPushClient.registerPush(context, APP_ID, APP_KEY);
    }

    public static void unRegisterPush(Context context){
        String registerInfo = PushShareUtil.getString(context.getApplicationContext(), XIAOMI_KEY);
        if (registerInfo != null){
            MiPushClient.unregisterPush(context);
            PushShareUtil.putString(context.getApplicationContext(), XIAOMI_KEY, null);
        }
    }
}
