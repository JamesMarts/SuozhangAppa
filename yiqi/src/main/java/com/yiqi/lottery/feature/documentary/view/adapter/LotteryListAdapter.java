package com.yiqi.lottery.feature.documentary.view.adapter;

import android.support.annotation.Nullable;
import android.text.Html;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yiqi.lottery.R;
import com.yiqi.lottery.entity.bo.LotteryBo;
import com.yiqi.lottery.entity.enums.LotteryType;

import java.util.List;

public class LotteryListAdapter extends BaseQuickAdapter<LotteryBo, BaseViewHolder> {

    private int type;

    public LotteryListAdapter(int type) {
        super(R.layout.item_documentary_lottery_list);
        this.type = type;
    }

    @Override
    protected void convert(BaseViewHolder helper, LotteryBo item) {
        String content = "";
        if (type == LotteryType.LIANHONG.getIndex()) {
            content = "<font color=\"#EA002A\">" + helper.getAdapterPosition() + "</font>连红";
        } else if (type == LotteryType.HONGDAN.getIndex()) {
            content = "投<font color=\"#EA002A\">" + 6 + "</font>单红<font color=\"#EA002A\">" + 5 + "</font>";
        }

        helper.setText(R.id.tv_lottery_level, item.getName())
                .setText(R.id.tv_lottery_type, Html.fromHtml(content));
        if (helper.getAdapterPosition() == 0) {
            helper.setBackgroundRes(R.id.tv_lottery_level, R.drawable.documentary_list_first_sign);
        } else if (helper.getAdapterPosition() == 1) {
            helper.setBackgroundRes(R.id.tv_lottery_level, R.drawable.documentary_list_second_sign);
        } else if (helper.getAdapterPosition() == 2) {
            helper.setBackgroundRes(R.id.tv_lottery_level, R.drawable.documentary_list_third_sign);
        }
    }
}
