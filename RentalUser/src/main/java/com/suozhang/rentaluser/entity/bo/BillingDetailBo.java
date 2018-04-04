package com.suozhang.rentaluser.entity.bo;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.suozhang.framework.entity.bo.BaseEntity;
import com.suozhang.rentaluser.feature.life.view.adapter.PaymentRecordsAdapter;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/13 13:37
 */
public class BillingDetailBo implements  BaseEntity,MultiItemEntity {

    private String bilingName;
    private double bilingUnitPrice;
    private double bilingCost;
    private String unit;

    public BillingDetailBo(String bilingName, double bilingCost) {
        this.bilingName = bilingName;
        this.bilingCost = bilingCost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBilingName() {
        return bilingName;
    }

    public void setBilingName(String bilingName) {
        this.bilingName = bilingName;
    }

    public double getBilingUnitPrice() {
        return bilingUnitPrice;
    }

    public void setBilingUnitPrice(double bilingUnitPrice) {
        this.bilingUnitPrice = bilingUnitPrice;
    }

    public double getBilingCost() {
        return bilingCost;
    }

    public void setBilingCost(double bilingCost) {
        this.bilingCost = bilingCost;
    }

    public BillingDetailBo(String bilingName, double bilingUnitPrice, double bilingCost, String unit) {
        this.bilingName = bilingName;
        this.bilingUnitPrice = bilingUnitPrice;
        this.bilingCost = bilingCost;
        this.unit = unit;
    }

    public BillingDetailBo() {
    }

    @Override
    public String toString() {
        return "BillingDetailBo{" +
                "bilingName='" + bilingName + '\'' +
                ", bilingUnitPrice=" + bilingUnitPrice +
                ", bilingCost=" + bilingCost +
                '}';
    }

    @Override
    public int getItemType() {
        return PaymentRecordsAdapter.TYPE_BILLING_DETAIL;
    }
}
