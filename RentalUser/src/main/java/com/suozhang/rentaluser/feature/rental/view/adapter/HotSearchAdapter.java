package com.suozhang.rentaluser.feature.rental.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.BaseBo;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/9/19 16:45
 */
public class HotSearchAdapter extends BaseQuickAdapter<BaseBo, BaseViewHolder> {

    public HotSearchAdapter() {
        super(R.layout.item_hot_search_text);
    }

    @Override
    protected void convert(BaseViewHolder helper, BaseBo item) {
        helper.setText(R.id.tv_hot_name, item.getName());
    }
}
