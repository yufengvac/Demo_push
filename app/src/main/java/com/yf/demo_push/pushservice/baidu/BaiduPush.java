package com.yf.demo_push.pushservice.baidu;

import android.content.Context;
import android.text.TextUtils;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.yf.demo_push.pushservice.BasePush;
import com.yf.demo_push.pushservice.PushUtil;

/**
 * Created by Administrator on 2017/5/31.
 *
 */

public class BaiduPush extends BasePush{
    private static final String API_KEY = "9xIHz6FO3nVDcgglZnlhluTg";

    static final String BAIDU_BIND_INFO_KEY = "baiduBindInfoKey";
    static final String BAIDUPUSH_APPID_KEY = "baidupushAppIdkey";
    static final String BAIDUPUSH_USERID_KEY = "baidupushUserIdkey";
    static final String BAIDUPUSH_CHANNELID_KEY = "baidupushChannelIdkey";

    static final String BAIDU_PUSH_NAME = "baidu";

    public BaiduPush(){
        super(BAIDU_PUSH_NAME, BAIDU_BIND_INFO_KEY);
    }

    @Override
    protected void registerPush(Context context) {
        PushManager.startWork(context.getApplicationContext(), PushConstants.LOGIN_TYPE_API_KEY, API_KEY);
    }

    public static void unRegisterPush(Context context){
        String bindInfo = PushUtil.getString(context.getApplicationContext(),BAIDU_BIND_INFO_KEY);
        if ( !TextUtils.isEmpty(bindInfo)){
            PushManager.stopWork(context.getApplicationContext());
            PushUtil.putString(context.getApplicationContext(), BAIDU_BIND_INFO_KEY, null);
        }
    }
}
