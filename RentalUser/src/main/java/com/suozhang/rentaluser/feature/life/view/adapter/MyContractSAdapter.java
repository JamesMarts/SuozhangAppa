package com.suozhang.rentaluser.feature.life.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.common.util.DateUtil;
import com.suozhang.rentaluser.entity.bo.ContractBo;
import com.suozhang.rentaluser.entity.enums.ContractState;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/15 9:44
 */
public class MyContractSAdapter extends BaseQuickAdapter<ContractBo, BaseViewHolder> {
    public MyContractSAdapter() {
        super(R.layout.item_my_contract);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContractBo item) {
        helper.setText(R.id.tv_contract_signing_date, "签订日期:" + DateUtil.getTimeStr(item.getCreateTime()))
                .setText(R.id.tv_contract_signing_state, ContractState.getName(item.getContractState()))
                .setText(R.id.tv_contract_room_description, item.getRoomName())
                .setText(R.id.tv_contract_date_period, DateUtil.getTimeStr(item.getStartDate())
                        + "-" + DateUtil.getTimeStr(item.getEndDate()));

    }
}
