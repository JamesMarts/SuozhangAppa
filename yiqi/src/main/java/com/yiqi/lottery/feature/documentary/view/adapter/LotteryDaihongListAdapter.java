package com.yiqi.lottery.feature.documentary.view.adapter;

import android.text.Html;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yiqi.lottery.R;
import com.yiqi.lottery.entity.bo.LotteryBo;

public class LotteryDaihongListAdapter extends BaseQuickAdapter<LotteryBo, BaseViewHolder> {


    public LotteryDaihongListAdapter() {
        super(R.layout.item_documentary_lottery_lianhonglist);
    }

    @Override
    protected void convert(BaseViewHolder helper, LotteryBo item) {
        String content = "<font color=\"#EA002A\">" + 121+item.getName() + "</font>人";
        helper.setText(R.id.tv_lottery_level, item.getName())
                .setText(R.id.tv_lottery_count, Html.fromHtml(content));
        if (helper.getAdapterPosition() == 0) {
            helper.setBackgroundRes(R.id.tv_lottery_level, R.drawable.documentary_list_first_sign);
        } else if (helper.getAdapterPosition() == 1) {
            helper.setBackgroundRes(R.id.tv_lottery_level, R.drawable.documentary_list_second_sign);
        } else if (helper.getAdapterPosition() == 2) {
            helper.setBackgroundRes(R.id.tv_lottery_level, R.drawable.documentary_list_third_sign);
        }
    }
}
