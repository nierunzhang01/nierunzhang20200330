package com.bw.nierunzhang20200330.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.30<p>
 * <p>更改时间：2020.3.30<p>
 */
public class MyAppliaction extends Application {
    private static Context context;
    private static SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }

    public static Context getContext() {
        return context;
    }

    public static SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
}
