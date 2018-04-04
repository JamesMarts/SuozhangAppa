package com.suozhang.rentaluser.feature.life.view.adapter;

import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.common.util.DateUtil;
import com.suozhang.rentaluser.entity.bo.PaymentDetailBo;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/14 10:08
 */
public class PaymentRecordsAdapter extends BaseQuickAdapter<PaymentDetailBo, BaseViewHolder> {

    public static final int TYPE_BILLING_CYCLE = 0;
    public static final int TYPE_BILLING_DETAIL = 1;

    public PaymentRecordsAdapter() {
        super(R.layout.item_billing_cycle);
//        addItemType(TYPE_BILLING_CYCLE, R.layout.item_billing_cycle);
//        addItemType(TYPE_BILLING_DETAIL, R.layout.item_billing_detail);
    }

    @Override
    protected void convert(BaseViewHolder helper, PaymentDetailBo item) {
        helper.setText(R.id.tv_payment_detail_name, item.getRoomName())
                .setText(R.id.tv_payment_detail_cycle,( item.getBillStartDate()==null?"":DateUtil.getTimeStr(item.getBillStartDate()))
                        +"~"+( item.getBillEndDate()==null?"":DateUtil.getTimeStr(item.getBillEndDate())))
                .setText(R.id.tv_payment_detail_paytype, getType(item.getPayType()) + "")
                .setText(R.id.tv_payment_detail_time, TextUtils.isEmpty(item.getPayDateTime()) ? "未知":item.getPayDateTime())
                .setText(R.id.tv_payment_detail_cost, "￥" + item.getPayAmount())

        ;
    }

    public String getType(int type) {

        String msg = "";
        if (type == 1) {
            msg = "微信";
        } else if (type == 2) {
            msg = "支付宝";
        }else {
            msg = "未知";
        }

        return msg;
    }
}
