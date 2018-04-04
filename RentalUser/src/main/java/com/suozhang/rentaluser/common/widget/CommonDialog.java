/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.common.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
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
public class CommonDialog extends Dialog {
    private Context context;
    private String title;
    private MyClickListenerInterface listenerInterface;
    private LayoutInflater layoutInflater;
    private  boolean isShow=false;

    public CommonDialog(Context context, String title, MyClickListenerInterface anInterface) {
        super(context, R.style.card_dialog);
        this.context = context;
        this.title = title;
        this.listenerInterface = anInterface;
        layoutInflater = LayoutInflater.from(context);
    }

    public CommonDialog(Context context, String title) {
        super(context, R.style.card_dialog);
        this.context = context;
        this.title = title;
        layoutInflater = LayoutInflater.from(context);
    }
    public CommonDialog(Context context, String title, boolean isShow) {
        super(context, R.style.card_dialog);
        this.context = context;
        this.title = title;
        this.isShow=isShow;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        View view = layoutInflater.inflate(R.layout.dialog_common, null);
        setContentView(view);
        final TextView txtMessage = (TextView) view.findViewById(R.id.txt_hint_dialog_message);

        TextView buttonConfim = (TextView) view.findViewById(R.id.signon_button_up);
        TextView buttonCancle = (TextView) view.findViewById(R.id.signon_button_down);
        txtMessage.setText(Html.fromHtml(title));
        if (isShow){
            buttonConfim.setVisibility(View.GONE);
        }
        Window dialogWindow = getWindow();
        getWindow().setBackgroundDrawable(new BitmapDrawable());
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = context.getResources().getDisplayMetrics(); // 获取屏幕宽、高用
        lp.width = (int) (d.widthPixels * 0.86); // 高度设置为屏幕的0.6
        buttonConfim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        buttonCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listenerInterface != null) listenerInterface.doConfirm();
            }
        });
    }

    public void setListener(MyClickListenerInterface listener) {
        this.listenerInterface = listener;
    }


    public interface MyClickListenerInterface {
        void doConfirm();
    }


}
