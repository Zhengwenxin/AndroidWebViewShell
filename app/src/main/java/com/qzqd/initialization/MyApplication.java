package com.qzqd.initialization;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * Created by ZhengWenxin
 * on 2019/9/17 17:07
 * Describe:
 * 全局初始化类
 */
public class MyApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        //初始化
        init();

        MyApplication.context = getApplicationContext();

        /**
         * 2020/3/4 15:35 Zhengwenxin
         *
         * Application的registerActivityLifecycleCallbacks方法说明：
         * 自API 14开始引入的一个方法，用来监听所有Activity的生命周期回调，比如onActivityCreated,onActivityResumed等。
         */
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            }

            @Override
            public void onActivityStarted(Activity activity) {
            }

            @Override
            public void onActivityResumed(Activity activity) {
                MyActivityManager.getInstance().setCurrentActivity(activity);
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
            }
        });
    }

    /**
     * 返回当前应用的Context
     *
     * @return
     */
    public static Context getAppContext() {
        return MyApplication.context;
    }


    /**
     * 初始化
     */
    private void init() {
        initLogger();
    }

    /**
     * 初始化Logger框架
     */
    private void initLogger() {
        //FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
        //  .showThreadInfo(false)      //（可选）是否显示线程信息。 默认值为true
        //  .methodCount(2)               // （可选）要显示的方法行数。 默认2
        //  .methodOffset(7)               // （可选）设置调用堆栈的函数偏移值，0的话则从打印该Log的函数开始输出堆栈信息，默认是0
        //  .logStrategy(customLog)  //（可选）更改要打印的日志策略。 默认LogCat
        //  .tag("MyTAG")                  //（可选）每个日志的全局标记。 默认PRETTY_LOGGER（如上图）
        //  .build();
        //Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .tag("MyTAG")
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }


}
