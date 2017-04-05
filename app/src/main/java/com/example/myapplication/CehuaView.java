package com.example.myapplication;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Song on 2017/3/31.
 */

public class CehuaView extends LinearLayout {
    private float mPosX, mPosY, mCurPosX, mCurPosY;//记录mListViewDevice 滑动的位置
    private PointF start,end,control;


    public CehuaView(Context context) {
        super(context);


    }

    public CehuaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.cehua_view, this);
    }

    public CehuaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {


        // 初始化数据点和控制点的位置


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 根据触摸位置更新控制点，并提示重绘
//        control.x = event.getX();
//        control.y = event.getY();
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                mPosX = event.getX();
                mPosY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                mCurPosX = event.getX();
                mCurPosY = event.getY();

                break;
            case MotionEvent.ACTION_UP:
                if (mCurPosX - mPosX > 0 && (Math.abs(mCurPosX - mPosX) > 25)) {
                    //向下滑動
                    ObjectAnimator animator = ObjectAnimator.ofFloat(this, "scaleX", 1f,2f);
                    animator.setDuration(1000);
                    animator.start();

                } else if (mCurPosX - mPosX < 0 && (Math.abs(mCurPosX - mPosX) > 25)) {
                    //向上滑动

                }

                break;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
