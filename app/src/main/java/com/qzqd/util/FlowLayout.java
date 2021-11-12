package com.qzqd.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ZhengWenxin
 * on 2019/10/31 11:24
 * Describe:
 * 自定义布局 流布局
 */
public class FlowLayout extends ViewGroup {
    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     *    *
     *    * @param changed
     *    * @param l 左
     *    * @param t 上
     *    * @param r  右
     *    * @param b  下
     *    
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //获得子控件的数量
        int childCount = getChildCount();
        //当前子控件的左边坐标
        int cl = 0;
        //当前子控件的上边坐标
        int ct = 0;
        //ViewGroup整体宽度
        int width = r - l;
        //行高
        int lineHeight = 0;
        //遍历所有子控件
        for (int i = 0; i < childCount; i++) {
        //获取当前控件
            View childAt = getChildAt(i);
            //获取宽度
            int cw = childAt.getMeasuredWidth();
            //获取高度
            int ch = childAt.getMeasuredHeight();
            //当前控件右边
            int cr = cl + cw;
            //当前控件下边
            int cb = ct + ch;
            //判断是否换行
            if (cr > width) {
                //如果换行重新计算上下左右地值
                cl = 0;
                cr = cl + cw;
                ct += lineHeight;
                cb = ct + ch;
                //换行后，第一个控件作为最大行高
                lineHeight = ch;
            } else {
                //如果不换行，需要计算最大高度
                lineHeight = Math.max(lineHeight, ch);
            }
            childAt.layout(cl, ct, cr, cb);
            //横向向后移动一个，前面控件的右边作为后面控件的左边
            cl = cr;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //测量所有子控件
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }
}

