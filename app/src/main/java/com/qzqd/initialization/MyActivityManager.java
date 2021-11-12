package com.qzqd.initialization;

import android.app.Activity;

import java.lang.ref.WeakReference;

/**
 * Created by ZhengWenxin
 * on 2020/3/4 15:19
 * Describe:Acitivity 全局管理类
 */
public class MyActivityManager {
    private static MyActivityManager sInstance = new MyActivityManager();
    private WeakReference<Activity> sCurrentActivityWeakRef;
    private MyActivityManager() {
    }
    public static MyActivityManager getInstance() {
        return sInstance;
    }
    public Activity getCurrentActivity() {
        Activity currentActivity = null;
        if (sCurrentActivityWeakRef != null) {
            currentActivity = sCurrentActivityWeakRef.get();
        }
        return currentActivity;
    }
    public void setCurrentActivity(Activity activity) {
        sCurrentActivityWeakRef = new WeakReference<Activity>(activity);
    }
}
