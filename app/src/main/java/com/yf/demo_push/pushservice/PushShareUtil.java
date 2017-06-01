package com.yf.demo_push.pushservice;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/5/31.
 *
 */

public class PushShareUtil {
    private static final String PUSH_BIND_INFO = "PUSH_BIND_INFO";
    public static void putString(Context context, String key, String value){
        SharedPreferences preferences = context.getSharedPreferences(PUSH_BIND_INFO, Context.MODE_PRIVATE);
        preferences.edit().putString(key,value).apply();
    }

    public static String getString(Context context, String key){
        SharedPreferences preferences = context.getSharedPreferences(PUSH_BIND_INFO, Context.MODE_PRIVATE);
        return preferences.getString(key, null);
    }
}
