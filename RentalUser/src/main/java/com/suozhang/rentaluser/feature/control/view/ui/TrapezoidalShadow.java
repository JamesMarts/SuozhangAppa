/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.control.view.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/6/5 15:00
 */
public class TrapezoidalShadow extends View {


    public TrapezoidalShadow(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


            /*设置背景为白色*/
        canvas.drawColor(Color.parseColor("#177d7d7d"));
        Paint paint = new Paint();
          /*去锯齿*/
        paint.setAntiAlias(true);
          /*设置paint的颜色*/
        paint.setColor(Color.RED);
          /*设置paint的 style 为STROKE：空心*/
        paint.setStyle(Paint.Style.STROKE);
          /*设置paint的外框宽度*/
       // paint.setStrokeWidth(3);

        Path path = new Path();
        path.moveTo(10, 410);
        path.lineTo(70,410);
        path.lineTo(55,350);
        path.lineTo(25, 350);

        path.close();

        canvas.drawPath(path, paint);


    }
}
