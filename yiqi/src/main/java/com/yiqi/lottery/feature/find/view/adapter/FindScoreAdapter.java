package com.yiqi.lottery.feature.find.view.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yiqi.lottery.R;
import com.yiqi.lottery.entity.bo.FindScoreBo;
import com.yiqi.lottery.feature.lottery.view.adapter.HomeAdapter;

import java.util.List;

public class FindScoreAdapter extends BaseQuickAdapter<FindScoreBo,BaseViewHolder> {

    public FindScoreAdapter() {
        super(R.layout.item_find_score);
    }

    @Override
    protected void convert(BaseViewHolder helper, FindScoreBo item) {

    }
}
