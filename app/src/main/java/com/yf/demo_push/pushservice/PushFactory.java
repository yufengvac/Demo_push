package com.yf.demo_push.pushservice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import com.yf.demo_push.pushservice.baidu.BaiduPush;
import com.yf.demo_push.pushservice.huawei.HuaweiPush;
import com.yf.demo_push.pushservice.xiaomi.XiaomiPush;

/**
 * Created by Administrator on 2017/5/31.
 *
 */

public class PushFactory {
    private static IPush iPush;
    private static final String TAG = PushFactory.class.getSimpleName();
    public static void init(Context context){
        if (iPush == null){
            String manufacturer = Build.MANUFACTURER;
            if (manufacturer!=null && TextUtils.isEmpty(manufacturer)){
                manufacturer = manufacturer.toLowerCase();
                Log.e(TAG,"manufacturer="+manufacturer);
            }

            if (TextUtils.equals("xiaomi", manufacturer)){
                iPush = new XiaomiPush();
            }else if (TextUtils.equals("huawei", manufacturer)){
                iPush = new HuaweiPush();
            }else {
                iPush = new BaiduPush();
            }
            unregisterAllPushExcept(context,iPush);
        }
    }

    public static IPush getInstance(){
        return iPush;
    }

    private static void unregisterAllPushExcept(Context c, IPush iPush) {
        if (!(iPush instanceof BaiduPush)) {
            BaiduPush.unRegisterPush(c);
        }

        if (!(iPush instanceof HuaweiPush)) {
            HuaweiPush.unRegisterPush(c);
        }

        if (!(iPush instanceof XiaomiPush)) {
            XiaomiPush.unRegisterPush(c);
        }
    }
}
