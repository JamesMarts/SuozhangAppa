package com.yiqi.lottery.feature.documentary.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yiqi.lottery.R;
import com.yiqi.lottery.entity.bo.PersonalLotteryBo;

public class PersonalLotteryAdapter extends BaseQuickAdapter<PersonalLotteryBo, BaseViewHolder> {
    public PersonalLotteryAdapter() {
        super(R.layout.item_documentary_person);
    }

    @Override
    protected void convert(BaseViewHolder helper, PersonalLotteryBo item) {
        helper.addOnClickListener(R.id.btn_documentary_again);
    }
}
