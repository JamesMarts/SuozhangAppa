/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.control.view.adapter;

import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.CombineModelBo;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/3/31 15:49
 */
public class LightAdapter extends BaseQuickAdapter<CombineModelBo, BaseViewHolder> {
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener;

    public LightAdapter(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super(R.layout.item_light);
        this.onCheckedChangeListener=onCheckedChangeListener;
    }

    @Override
    protected void convert(BaseViewHolder helper, CombineModelBo item) {

        helper.setText(R.id.tv_light_name, item.getName()).setOnCheckedChangeListener(R.id.cb_light,onCheckedChangeListener).setTag(R.id.cb_light,item);

        CheckBox imageView=helper.getView(R.id.cb_light);
        if (item.getDeviceSubType()==4){
            imageView.setBackgroundResource(R.drawable.toggle_light_color_bg);
        }else if (item.getDeviceSubType()==1){
            imageView.setBackgroundResource(R.drawable.toggle_light_bg);
        }


    }



}
