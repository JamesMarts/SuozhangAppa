/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/5/4 10:34
 */
public class PayNotifyBo implements BaseEntity{

    /**
     * sign : sample string 1
     * payType : 0
     */

    private String sign;
    private int payType;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public PayNotifyBo(String sign, int payType) {
        this.sign = sign;
        this.payType = payType;
    }

    public PayNotifyBo() {
    }

    @Override
    public String toString() {
        return "PayNotifyBo{" +
                "sign='" + sign + '\'' +
                ", payType=" + payType +
                '}';
    }
}
