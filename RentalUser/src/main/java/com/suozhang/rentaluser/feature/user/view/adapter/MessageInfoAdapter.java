/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.view.adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.common.util.DateUtil;
import com.suozhang.rentaluser.entity.bo.MessageBo;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/21 18:23
 */
public class MessageInfoAdapter extends BaseQuickAdapter<MessageBo, BaseViewHolder> {


    public MessageInfoAdapter() {
        super(R.layout.item_message_info);
    }


    @Override
    protected void convert(BaseViewHolder helper, MessageBo item) {
        helper.setText(R.id.tv_message_content, item.getContent())
                .setText(R.id.tv_message_name,item.getTitle())
                .setVisible(R.id.iv_message_read, !item.isIsRead());




        TextView tvDate = helper.getView(R.id.tv_message_date);



        boolean num = DateUtil.isToday(item.getCreateTime());

        if (num) {
            tvDate.setText(DateUtil.getHourByDate(item.getCreateTime()));
        } else {
            tvDate.setText(DateUtil.getTimeStr(item.getCreateTime()));
        }



    }
}
