package com.suozhang.rentaluser.feature.life.view.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.ContractInfoBo;

import java.util.List;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/13 13:36
 */
public class RentInfoAdapter extends BaseQuickAdapter<ContractInfoBo.AppMeterBo, BaseViewHolder> {
    private int colorRes;


    public RentInfoAdapter( @Nullable List<ContractInfoBo.AppMeterBo> data, int colorRes) {
        super(R.layout.item_rent_scan_info, data);
        this.colorRes = colorRes;
    }

    @Override
    protected void convert(BaseViewHolder helper, ContractInfoBo.AppMeterBo item) {
        helper.setText(R.id.tv_rent_money_info_name, item.getTypeName())
                .setText(R.id.tv_rent_money_info_price, item.getScale() + "")
        ;

    }
}
