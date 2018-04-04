package com.suozhang.framework.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.suozhang.framework.R;


/**
 * Created by GEILI on 2017/10/18.
 */

public class LoadingView extends View {

    private int width;

    private int height;

    private int centerX;

    private int centerY;

    private Paint paint;

    private final int defaultColor = 0xff999999;

    private final int defaultSegmentWidth = 10;

    private final int defaultSegmentLength = 20;

    private int segmentWidth = defaultSegmentWidth;

    private int segmentColor = defaultColor;

    private int segmentLength = defaultSegmentLength;

    private int control = 1;

    public LoadingView(Context context) {
        this(context, null);
    }



    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }



    public LoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LoadingView);

        int indexCount = typedArray.getIndexCount();

        for (int i = 0; i < indexCount; i++) {

            int attr = typedArray.getIndex(i);

            if (attr == R.styleable.LoadingView_pathColor) {
                segmentColor = typedArray.getColor(attr, defaultColor);


            } else if (attr == R.styleable.LoadingView_segmentLength) {
                segmentLength = typedArray.getDimensionPixelSize(attr, defaultSegmentLength);


            } else if (attr == R.styleable.LoadingView_segmentWidth) {
                segmentWidth = typedArray.getDimensionPixelSize(attr, defaultSegmentWidth);


            }

        }

        typedArray.recycle();



        paint = new Paint();

        paint.setAntiAlias(true);

        paint.setStrokeCap(Paint.Cap.ROUND);

        paint.setStyle(Paint.Style.STROKE);

        paint.setColor(segmentColor);

        paint.setStrokeWidth(segmentWidth);



    }



    @Override

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        width = MeasureSpec.getSize(widthMeasureSpec);

        height = MeasureSpec.getSize(heightMeasureSpec);

        centerX = width / 2;

        centerY = height / 2;

    }



    @Override

    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        for (int i = 0; i < 12; i++) {

            paint.setAlpha(((i + 1 + control) % 12 * 255) / 12);

            canvas.drawLine(centerX, centerY - segmentLength, centerX, centerY - segmentLength*2, paint);
            //每次旋转30度
            canvas.rotate(30, centerX, centerY);

        }

    }



    @Override

    protected void onFinishInflate() {

        super.onFinishInflate();

        ValueAnimator valueAnimator = ValueAnimator.ofInt(12, 1);

        valueAnimator.setDuration(1000);

        valueAnimator.setInterpolator(new LinearInterpolator());

        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);

        valueAnimator.setRepeatMode(ValueAnimator.RESTART);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override

            public void onAnimationUpdate(ValueAnimator animation) {

                control = (int) animation.getAnimatedValue();

                invalidate();

            }

        });

        valueAnimator.start();

    }

}
