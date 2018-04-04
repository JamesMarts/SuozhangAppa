/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.view.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suozhang.framework.framework.AM;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.common.util.DateUtil;
import com.suozhang.rentaluser.entity.bo.MessageBo;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/21 18:23
 */
public class MessageAdapter extends BaseQuickAdapter<MessageBo, BaseViewHolder> {


    public MessageAdapter() {
        super(R.layout.item_message);
    }


    @Override
    protected void convert(BaseViewHolder helper, MessageBo item) {
        helper.setText(R.id.tv_message_content, item.getTitle()).setText(R.id.tv_message_name,item.getName())
                .setVisible(R.id.iv_message_read, !item.isIsRead());

//        helper.getLayoutPosition();


        TextView textView = helper.getView(R.id.tv_message_name);
        TextView tvDate = helper.getView(R.id.tv_message_date);

        ImageView imageView = helper.getView(R.id.iv_message_image);

        boolean num = DateUtil.isToday(item.getCreateTime());

        if (num) {
            tvDate.setText(DateUtil.getHourByDate(item.getCreateTime()));
        } else {
            tvDate.setText(DateUtil.getTimeStr(item.getCreateTime()));
        }

        AM.image().bind(item.getIconUrl(),imageView);


    }
}
