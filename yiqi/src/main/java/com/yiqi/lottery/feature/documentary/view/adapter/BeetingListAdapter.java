package com.yiqi.lottery.feature.documentary.view.adapter;

import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yiqi.lottery.R;
import com.yiqi.lottery.entity.bo.BeetingBo;

import java.util.List;

public class BeetingListAdapter extends BaseQuickAdapter<BeetingBo,BaseViewHolder> {
    public BeetingListAdapter() {
        super(R.layout.item_user_beeting);
    }

    @Override
    protected void convert(BaseViewHolder helper, BeetingBo item) {

    }
}
