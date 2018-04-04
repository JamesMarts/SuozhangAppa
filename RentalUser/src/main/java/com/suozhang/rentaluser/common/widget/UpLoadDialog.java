/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.common.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.suozhang.rentaluser.R;


/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/25 15:22
 */
public class UpLoadDialog extends Dialog {
    private Context context;
    private LayoutInflater layoutInflater;
    private MyClickListenerInterface btnCarmaListenerInterface;
    private String text1,text2;


    public UpLoadDialog(Context context,String text1,String text2) {
        super(context, R.style.card_dialog_map);
        this.context = context;
        this.text1=text1;
        this.text2=text2;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        View view = layoutInflater.inflate(R.layout.dialog_user_change, null);
        setContentView(view);

        TextView btnBaidu = (TextView) view.findViewById(R.id.tv_map_dialog_baidu);
        TextView btnGaode = (TextView) view.findViewById(R.id.tv_map_dialog_gaode);
        TextView buttonCancle = (TextView) view.findViewById(R.id.tv_map_dialog_cancle);
        btnBaidu.setText(text1);
        btnGaode.setText(text2);
        Window dialogWindow = getWindow();
        getWindow().setBackgroundDrawable(new BitmapDrawable());
        setCanceledOnTouchOutside(true);
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = context.getResources().getDisplayMetrics(); // 获取屏幕宽、高用
        lp.width = (int) (d.widthPixels * 0.95); // 高度设置为屏幕的0.6
        lp.y = 25;
        dialogWindow.setAttributes(lp);

        buttonCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btnBaidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnCarmaListenerInterface != null) btnCarmaListenerInterface.doCarema();

            }
        });

        btnGaode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnCarmaListenerInterface != null) btnCarmaListenerInterface.doGallery();
            }
        });

    }


    public void setListener(MyClickListenerInterface listener) {
        this.btnCarmaListenerInterface = listener;
    }


    public interface MyClickListenerInterface {
        void doCarema();

        void doGallery();
    }


}
