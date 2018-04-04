package com.suozhang.rentaluser.feature.life.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.RepairServiceBo;
import com.suozhang.rentaluser.entity.enums.RepairState;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/15 9:44
 */
public class MyRepairAdapter extends BaseQuickAdapter<RepairServiceBo, BaseViewHolder> {
    public MyRepairAdapter() {
        super(R.layout.item_repair_service);
    }

    @Override
    protected void convert(BaseViewHolder helper, RepairServiceBo item) {
        helper.setText(R.id.tv_repair_service_date, item.getRepairDate())
                .setText(R.id.tv_repair_service_state, RepairState.getName(item.getRepairState()))
                .setText(R.id.tv_repair_service_info, item.getRepairInfo());
    }
}
