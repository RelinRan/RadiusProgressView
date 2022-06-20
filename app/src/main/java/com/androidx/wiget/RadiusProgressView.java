package com.androidx.wiget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 圆角进度
 */
public class RadiusProgressView extends View {

    private Paint paint;
    //圆角
    private int radius = 90;
    //进度值
    private int progress = 50;
    //进度最大值
    private int max = 100;
    //背景颜色
    private int solidColor = Color.parseColor("#EBEBEB");
    //进度颜色
    private int progressColor = Color.parseColor("#0347FE");

    public RadiusProgressView(Context context) {
        super(context);
        initAttributeSet(context,null);
    }

    public RadiusProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttributeSet(context,attrs);
    }

    public RadiusProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttributeSet(context,attrs);
    }

    private void initAttributeSet(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.RadiusProgressView);
            radius = array.getDimensionPixelSize(R.styleable.RadiusProgressView_android_radius, radius);
           progress = array.getInt(R.styleable.RadiusProgressView_android_progress, progress);
            solidColor = array.getColor(R.styleable.RadiusProgressView_solidColor, solidColor);
            progressColor = array.getColor(R.styleable.RadiusProgressView_progressColor, progressColor);
            array.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(solidColor);
        RectF bgRect = new RectF(0, 0, getWidth(), getHeight());
        canvas.drawRoundRect(bgRect, radius, radius, paint);
        //进度
        paint.setColor(progressColor);
        RectF psRect = new RectF(0, 0, getWidth() * progress / max, getHeight());
        canvas.drawRoundRect(psRect, radius, radius, paint);
    }

    /**
     * 设置最大值
     *
     * @param max
     */
    public void setMax(int max) {
        this.max = max;
        invalidate();
    }

    /**
     * 设置进度值
     *
     * @param progress
     */
    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }

    /**
     * 设置进度颜色
     *
     * @param progressColor
     */
    public void setProgressColor(int progressColor) {
        this.progressColor = progressColor;
        invalidate();
    }

    /**
     * 设置背景颜色
     *
     * @param solidColor
     */
    public void setSolidColor(int solidColor) {
        this.solidColor = solidColor;
        invalidate();
    }

}