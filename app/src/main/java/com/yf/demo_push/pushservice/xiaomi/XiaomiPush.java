package com.yf.demo_push.pushservice.xiaomi;

import android.content.Context;
import android.text.TextUtils;

import com.xiaomi.mipush.sdk.MiPushClient;
import com.yf.demo_push.pushservice.BasePush;
import com.yf.demo_push.pushservice.PushUtil;

/**
 * Created by Administrator on 2017/5/31.
 *
 */

public class XiaomiPush extends BasePush{

    private static final String APP_ID = "2882303761517582471";
    private static final String APP_KEY = "5491758253471";
    static final String XIAOMI_KEY = "xiaomi_key";
    static final String XIAOMI_PUSH_NAME = "xiaomi";

    public XiaomiPush(){
        super(XIAOMI_PUSH_NAME, XIAOMI_KEY);
    }
    @Override
    protected void registerPush(Context context) {
        MiPushClient.registerPush(context, APP_ID, APP_KEY);
    }

    public static void unRegisterPush(Context context){
        String registerInfo = PushUtil.getString(context.getApplicationContext(), XIAOMI_KEY);
        if (!TextUtils.isEmpty(registerInfo)){
            MiPushClient.unregisterPush(context);
            PushUtil.putString(context.getApplicationContext(), XIAOMI_KEY, null);
        }
    }
}
