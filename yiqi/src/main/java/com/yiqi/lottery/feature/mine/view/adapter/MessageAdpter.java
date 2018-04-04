package com.yiqi.lottery.feature.mine.view.adapter;

import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suozhang.framework.framework.AM;
import com.yiqi.lottery.R;
import com.yiqi.lottery.entity.bo.MessageBo;

import java.util.List;

public class MessageAdpter extends BaseQuickAdapter<MessageBo,BaseViewHolder> {
    public MessageAdpter() {
        super(R.layout.item_user_message);
    }

    @Override
    protected void convert(BaseViewHolder helper, MessageBo item) {
        AM.image().bindToCircleObject("http://img5.duitang.com/uploads/item/201609/26/20160926124027_vxRkt.jpeg",helper.getView(R.id.iv_user_message_head));
    }
}
