package com.qzqd.util;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.qzqd.R;

/**
 * @author zhengwenxin
 * @date 2020/2/13.
 * Email：naja2@qq.com
 * Description：圆形进度条Dialog
 */
public class ProgressDialog {

    private static volatile ProgressDialog instance;

    private ProgressDialog() {
    }

    public static ProgressDialog getInstance() {
        if (instance == null) {
            synchronized (ProgressDialog.class) {
                if (instance == null) {
                    instance = new ProgressDialog();
                }
            }
        }
        return instance;
    }

    private MaterialDialog materialDialog;

    public void show(Context mContext) {
        materialDialog = new MaterialDialog.Builder(mContext)
//                .title(R.string.progress_dialog_title)
                .content(R.string.progress_please_wait)
                .progress(true, 0)
                .cancelable(false)
                .progressIndeterminateStyle(false)
                .show();

    }

    public void dismiss() {
        materialDialog.dismiss();
    }
}
