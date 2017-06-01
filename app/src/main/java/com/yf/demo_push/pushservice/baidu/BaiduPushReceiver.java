package com.yf.demo_push.pushservice.baidu;

import android.content.Context;
import android.util.Log;

import com.baidu.android.pushservice.PushMessageReceiver;

import java.util.List;

/**
 * Created by Administrator on 2017/5/31.
 *
 */

public class BaiduPushReceiver extends PushMessageReceiver{
    private static final String TAG = BaiduPushReceiver.class.getSimpleName();


    /**
     * 调用PushManager.startWork后，sdk将对push server发起绑定请求，这个过程是异步的。
     * 绑定请求的结果通过onBind返回。 如果您需要用单播推送，需要把这里获取的channel id和user id上传到应用server中，再调用server接口用channel id和user id给单个手机或者用户推送。
     *
     * @param context   BroadcastReceiver的执行Context
     * @param errorCode 绑定接口返回值，0 - 成功
     * @param appId     应用id。errorCode非0时为null
     * @param userId    应用user id。errorCode非0时为null
     * @param channelId 应用channel id。errorCode非0时为null
     * @param requestId 向服务端发起的请求id。在追查问题时有用；
     */
    @Override
    public void onBind(Context context, int errorCode, String appId, String userId, String channelId, String requestId) {
        Log.e(TAG,"onBind--->errorCode="+errorCode+",appId="+appId+",userId="+userId+",channeld="+channelId+",requestId="+requestId);
    }

    /**
     * PushManager.stopWork() 的回调函数。
     *
     * @param context   上下文
     * @param errorCode 错误码。0表示从云推送解绑定成功；非0表示失败。
     * @param requestId 分配给对云推送的请求的id
     */
    @Override
    public void onUnbind(Context context, int errorCode, String requestId) {
        Log.e(TAG,"onUnbind--->errorCode="+errorCode+",requestId="+requestId);
    }

    @Override
    public void onSetTags(Context context, int i, List<String> list, List<String> list1, String s) {

    }

    @Override
    public void onDelTags(Context context, int i, List<String> list, List<String> list1, String s) {

    }

    @Override
    public void onListTags(Context context, int i, List<String> list, String s) {

    }

    /**
     * 接收透传消息的函数。
     *
     * @param context             上下文
     * @param message             推送的消息
     * @param customContentString 自定义内容,为空或者json字符串
     */
    @Override
    public void onMessage(Context context, String message, String customContentString) {
        Log.e(TAG,"onMessage--->message="+message+",customContentString="+customContentString);
    }

    /***
     * 消息被电击
     * @param context      上下文
     * @param title        消息标题
     * @param description  消息内容
     * @param customString 自定义内容
     */
    @Override
    public void onNotificationClicked(Context context, String title, String description, String customString) {
        Log.e(TAG,"onNotificationClicked--->title="+title+",description="+description+",customString="+customString);
    }

    /**
     * 消息到达
     * @param context   上下文
     * @param title     消息标题
     * @param content   消息内容
     * @param extra     自定义内容
     */
    @Override
    public void onNotificationArrived(Context context, String title, String content, String extra) {
        Log.e(TAG,"onNotificationArrived--->title="+title+",content="+content+",extra="+extra);
    }
}
