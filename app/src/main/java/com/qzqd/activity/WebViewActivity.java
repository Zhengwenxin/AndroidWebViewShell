package com.qzqd.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.qzqd.R;
import com.qzqd.initialization.MyActivityManager;
import com.qzqd.initialization.MyApplication;
import com.qzqd.util.LoginUserUtilsSP;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ZhengWenxin
 * Rockwell Automation, Inc.
 * on 2021/11/5 10:06
 * Describe:
 */
public class WebViewActivity extends AppCompatActivity {
    private Activity currentActivity;
    private Context currentContext;
    private Unbinder unbinder;

    @BindView(R.id.webview)
    WebView webview1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        unbinder = ButterKnife.bind(this);
        //获取当前Activity和Context
        currentActivity = MyActivityManager.getInstance().getCurrentActivity();
        currentContext = MyApplication.getAppContext();
        initView();
    }

    public void initView() {
        Map<String, String> webInfo =  LoginUserUtilsSP.getWebInfo(currentContext);

        // 获取webSettings
        WebSettings settings = webview1.getSettings();
        // 支持js
        settings.setJavaScriptEnabled(true);
        // 设置编码
        settings.setDefaultTextEncodingName("utf-8");
        // 不使用缓存
        // settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        // 在LOAD_CACHE_ELSE_NETWORK模式下，无论是否有网络，只要本地有缓存，
        // 都使用缓存。本地没有缓存时才从网络上获取。
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        // 配置缓存，否则百度地图不显示
        // 设置启用或禁止访问文件数据
        settings.setAllowFileAccess(true);
        // 最重要的方法，一定要设置，这就是出不来的主要原因
        settings.setDomStorageEnabled(true);
        // 启用数据库
        // settings.setDatabaseEnabled(true);
        // String dir = this.getApplicationContext().getDir("database", Context.MODE_PRIVATE).getPath();
        // 启用地理定位
        // settings.setGeolocationEnabled(true);
        // 设置定位的数据库路径
        // settings.setGeolocationDatabasePath(dir);
        // 设置可以支持缩放
        settings.setSupportZoom(false);
        // 设置出现缩放工具
        settings.setBuiltInZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        webview1.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        // 最小缩放等级
        webview1.setInitialScale(Integer.parseInt((webInfo.get("zoom"))));

        String webViewUrl = webInfo.get("webViewUrl");

        //如果不设置WebViewClient，请求会跳转系统浏览器
        webview1.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //该方法在Build.VERSION_CODES.LOLLIPOP以前有效，从Build.VERSION_CODES.LOLLIPOP起，建议使用shouldOverrideUrlLoading(WebView, WebResourceRequest)} instead
                //返回false，意味着请求过程里，不管有多少次的跳转请求（即新的请求地址），均交给webView自己处理，这也是此方法的默认处理
                //返回true，说明你自己想根据url，做新的跳转
                if (url.toString().contains("sina.cn")){
                    view.loadUrl(webViewUrl);
                    return true;
                }

                return false;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request)
            {
                //返回false，意味着请求过程里，不管有多少次的跳转请求（即新的请求地址），均交给webView自己处理，这也是此方法的默认处理
                //返回true，说明你自己想根据url，做新的跳转
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (request.getUrl().toString().contains("sina.cn")){
                        view.loadUrl(webViewUrl);
                        return true;
                    }
                }

                return false;
            }

        });

        webview1.loadUrl(webViewUrl);
    }

}
