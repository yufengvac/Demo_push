package com.yf.demo_push.pushservice.xiaomi;

import android.content.Context;
import android.util.Log;

import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.yf.demo_push.pushservice.PushUtil;

import java.util.List;

/**
 * Created by yufeng on 2017/6/1.
 *
 */

public class XiaomiPushReceiver extends PushMessageReceiver{

    private static final String TAG = XiaomiPushReceiver.class.getSimpleName();
    public XiaomiPushReceiver() {

    }

    @Override
    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        Log.e(TAG,"onReceivePassThroughMessage--->miPushMessage.toString()="+miPushMessage.toString());
        PushUtil.sendTransparentMsgBroadcast(context, miPushMessage.getContent(), XiaomiPush.XIAOMI_PUSH_NAME);
    }

    @Override
    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        Log.e(TAG,"onNotificationMessageClicked--->miPushMessage.toString()="+miPushMessage.toString());
        PushUtil.sendClickedBroadcast(context, miPushMessage.getContent(), XiaomiPush.XIAOMI_PUSH_NAME);
    }

    @Override
    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        Log.e(TAG,"onNotificationMessageArrived--->miPushMessage.toString()="+miPushMessage.toString());
        PushUtil.sendShowNotificationBroadcast(context,miPushMessage.getContent(), XiaomiPush.XIAOMI_PUSH_NAME);
    }

    @Override
    public void onReceiveMessage(Context context, MiPushMessage miPushMessage) {
        Log.e(TAG,"onReceiveMessage--->miPushMessage.toString()="+miPushMessage.toString());
    }

    @Override
    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        String command = miPushCommandMessage.getCommand();
        List<String> arguments = miPushCommandMessage.getCommandArguments();
        String regId = (arguments != null && arguments.size()>0)?arguments.get(0):null;
        if (MiPushClient.COMMAND_REGISTER.equals(command)&& miPushCommandMessage.getResultCode()
                == ErrorCode.SUCCESS && regId != null){
            Log.e(TAG,"onRecevieRegisterResult--->regId="+regId);
            PushUtil.putString(context, XiaomiPush.XIAOMI_KEY, regId);
            PushUtil.sendRegisterBroadcast(context, XiaomiPush.XIAOMI_PUSH_NAME);
        }
    }

    @Override
    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {

    }
}
