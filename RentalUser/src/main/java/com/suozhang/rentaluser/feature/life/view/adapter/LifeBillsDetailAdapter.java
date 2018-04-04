package com.suozhang.rentaluser.feature.life.view.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.MyLifeBo;

import java.util.List;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/13 13:36
 */
public class LifeBillsDetailAdapter extends BaseQuickAdapter<MyLifeBo.AppUserBillInfoBo, BaseViewHolder> {
    public LifeBillsDetailAdapter(@Nullable List<MyLifeBo.AppUserBillInfoBo> data) {
        super(R.layout.item_life_billing_details, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyLifeBo.AppUserBillInfoBo item) {
        helper.setText(R.id.tv_life__billing_detail_name, item.getCostName())
                .setText(R.id.tv_life__billing_detail_price, item.getPrice() +item.getUnit())
                .setText(R.id.tv_life__billing_detail_cost, item.getAmount() + "");
    }
}