package com.yf.demo_push.pushservice.baidu;

import android.content.Context;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.yf.demo_push.pushservice.BasePush;
import com.yf.demo_push.pushservice.PushShareUtil;

/**
 * Created by Administrator on 2017/5/31.
 *
 */

public class BaiduPush extends BasePush{
    private static final String API_KEY = "9xIHz6FO3nVDcgglZnlhluTg";
    private static final String BAIDUPUSH_KEY = "baidupush_key";
    @Override
    protected void registerPush(Context context) {
        PushManager.startWork(context.getApplicationContext(), PushConstants.LOGIN_TYPE_API_KEY, API_KEY);
    }

    public static void unRegisterPush(Context context){
        String bindInfo = PushShareUtil.getString(context.getApplicationContext(),BAIDUPUSH_KEY);
        if (bindInfo != null){
            PushManager.stopWork(context.getApplicationContext());
            PushShareUtil.putString(context.getApplicationContext(), BAIDUPUSH_KEY, null);
        }
    }
}
