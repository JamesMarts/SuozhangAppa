package com.suozhang.rentaluser.entity.bo;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.suozhang.rentaluser.feature.life.view.adapter.PaymentRecordsAdapter;

import java.util.List;

/**
 * Created by luoxw on 2016/8/10.
 */
public class BillingCycleBo extends AbstractExpandableItem<BillingDetailBo> implements MultiItemEntity {
    public String title;
    public String week;
    public String startDate;
    public String endDate;
    private List<BillingDetailBo> billingDetailBos;

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public BillingCycleBo() {
    }

    public List<BillingDetailBo> getBillingDetailBos() {
        return billingDetailBos;
    }

    public void setBillingDetailBos(List<BillingDetailBo> billingDetailBos) {
        this.billingDetailBos = billingDetailBos;
    }

    public BillingCycleBo(String week, String startDate, String endDate, List<BillingDetailBo> billingDetailBos) {
        this.week = week;
        this.startDate = startDate;
        this.endDate = endDate;
        this.billingDetailBos = billingDetailBos;
    }

    @Override
    public int getItemType() {
        return PaymentRecordsAdapter.TYPE_BILLING_CYCLE;
    }

    @Override
    public int getLevel() {
        return 0;
    }
}
