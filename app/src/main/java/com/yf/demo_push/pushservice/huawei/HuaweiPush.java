package com.yf.demo_push.pushservice.huawei;

import android.content.Context;
import android.text.TextUtils;

import com.huawei.android.pushagent.api.PushManager;
import com.yf.demo_push.pushservice.BasePush;
import com.yf.demo_push.pushservice.PushUtil;

/**
 * Created by Administrator on 2017/5/31.
 *
 */

public class HuaweiPush extends BasePush{
    private static final String TAG = HuaweiPush.class.getSimpleName();
    static final String HUAWEI_KEY ="huawei_key";
    static final String HUAWEI_PUSH_NAME = "huawei";

    public HuaweiPush(){
        super(HUAWEI_PUSH_NAME, HUAWEI_KEY);
    }

    @Override
    protected void registerPush(Context context) {
        PushManager.requestToken(context);
    }

    public static void unRegisterPush(Context context){
        String token = PushUtil.getString(context.getApplicationContext(),HUAWEI_KEY);
        if (!TextUtils.isEmpty(token)){
            PushManager.deregisterToken(context , token);
            PushUtil.putString(context, HUAWEI_KEY, null);
        }
    }
}
