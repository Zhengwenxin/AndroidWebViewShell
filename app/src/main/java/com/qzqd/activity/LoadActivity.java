package com.qzqd.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.qzqd.R;
import com.qzqd.initialization.MyActivityManager;
import com.qzqd.initialization.MyApplication;
import com.qzqd.util.LoginUserUtilsSP;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ZhengWenxin
 * on 2021/11/5 10:06
 * Describe:
 */
public class LoadActivity extends AppCompatActivity {
    private Activity currentActivity;
    private Context currentContext;
    private Unbinder unbinder;

    @BindView(R.id.button)
    Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        unbinder = ButterKnife.bind(this);
        //获取当前Activity和Context
        currentActivity = MyActivityManager.getInstance().getCurrentActivity();
        currentContext = MyApplication.getAppContext();
        initView();
    }

    public void initView() {
        Timer timer=new Timer();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(LoadActivity.this,WebViewActivity.class);
                startActivity(intent);
                LoadActivity.this.finish();
            }
        };
        timer.schedule(task,2000);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                customView();

            }
        });

    }
    /**
     * 自定义弹窗
     */
    private void customView() {
        final View loginForm = getLayoutInflater().inflate(R.layout.view_write_dm_result, null);

        //http://192.168.1.200:8081/dist
        //
        //弹窗的三个EditText
        EditText zoom = (EditText) loginForm.findViewById(R.id.editTextNumber);
        EditText webUrl = (EditText) loginForm.findViewById(R.id.edittext_remark);
        Switch switch1 = (Switch) loginForm.findViewById(R.id.switch1);
        Map<String, String> webInfo = LoginUserUtilsSP.getWebInfo(currentContext);
        zoom.setText(webInfo.get("zoom"));
        webUrl.setText(webInfo.get("webViewUrl"));
        //弹窗界面设置
        final AlertDialog alertDialog = new AlertDialog.Builder(this)
//                .setIcon(R.drawable.ic_dashboard_black_24dp)
//                .setTitle("输入拆分数据")
                .setView(loginForm)
                //弹窗取消按钮
//                .setNegativeButton("更改", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        LoginUserUtilsSP.setWebInfo(currentContext,webUrl.getText().toString(), zoom.getText().toString());
//
//                    }
//                })
                //弹窗拆分按钮
                .setPositiveButton("跳转", new DialogInterface
                        .OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LoginUserUtilsSP.setWebInfo(currentContext,webUrl.getText().toString(), zoom.getText().toString());
                        Intent intent=new Intent(LoadActivity.this,WebViewActivity.class);
                        startActivity(intent);
                        LoadActivity.this.finish();

                    }
                })
                .create();
        alertDialog.show();

        //设置弹窗两个按钮样式
        Button btnPositive = alertDialog.getButton(android.app.AlertDialog.BUTTON_POSITIVE);
        Button btnNegative = alertDialog.getButton(android.app.AlertDialog.BUTTON_NEGATIVE);
        btnPositive.setTextColor(getResources().getColor(R.color.btn_normal));
        btnPositive.setTextSize(18);
        btnNegative.setTextColor(getResources().getColor(R.color.colorPrimary));
        btnNegative.setTextSize(18);
    }


}
