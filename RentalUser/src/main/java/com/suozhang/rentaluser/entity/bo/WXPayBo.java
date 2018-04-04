/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/15 14:42
 */
public class WXPayBo implements BaseEntity {


    /**
     * partnerId : 1465438802
     * prepayId : wx2017083116121653a41928650225833596
     * sign : 1CC5454AB51F80CE0EA797FA8923D4D0
     * appId : wxfde91a9fce434565
     * timeStamp : 1504167050
     * nonceStr : 5878A7AB84FB43402106C575658472FA
     * package : Sign=WXPay
     * signType : MD5
     * paySign : null
     */

    private String partnerId;
    private String prepayId;
    private String sign;
    private String appId;
    private String timeStamp;
    private String nonceStr;

    private String signType;
    private Object paySign;

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }



    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public Object getPaySign() {
        return paySign;
    }

    public void setPaySign(Object paySign) {
        this.paySign = paySign;
    }

    @Override
    public String toString() {
        return "WXPayBo{" +
                "partnerId='" + partnerId + '\'' +
                ", prepayId='" + prepayId + '\'' +
                ", sign='" + sign + '\'' +
                ", appId='" + appId + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", signType='" + signType + '\'' +
                ", paySign=" + paySign +
                '}';
    }
}
