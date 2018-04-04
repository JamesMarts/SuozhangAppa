/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

import java.util.Date;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/5/4 11:40
 */
public class PayNotifyRes implements BaseEntity{


    /**
     * couponAmount : 1.0
     * couponMinUseAmount : 2.0
     * couponStartTime : 2017-07-06 13:54:31
     * couponEndTime : 2017-07-06 13:54:31
     * payType : sample string 5
     * roomTypeName : sample string 6
     * payAmount : 7.0
     * sheetCode : sample string 8
     * orderStartTime : 2017-07-06 13:54:31
     * orderEndTime : 2017-07-06 13:54:31
     * roomCount : 11
     */

    private double couponAmount;
    private double couponMinUseAmount;
    private Date couponStartTime;
    private Date couponEndTime;
    private String payType;
    private String roomTypeName;
    private double payAmount;
    private String sheetCode;
    private Date orderStartTime;
    private Date orderEndTime;
    private int roomCount;

    public double getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(double couponAmount) {
        this.couponAmount = couponAmount;
    }

    public double getCouponMinUseAmount() {
        return couponMinUseAmount;
    }

    public void setCouponMinUseAmount(double couponMinUseAmount) {
        this.couponMinUseAmount = couponMinUseAmount;
    }

    public Date getCouponStartTime() {
        return couponStartTime;
    }

    public void setCouponStartTime(Date couponStartTime) {
        this.couponStartTime = couponStartTime;
    }

    public Date getCouponEndTime() {
        return couponEndTime;
    }

    public void setCouponEndTime(Date couponEndTime) {
        this.couponEndTime = couponEndTime;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    public String getSheetCode() {
        return sheetCode;
    }

    public void setSheetCode(String sheetCode) {
        this.sheetCode = sheetCode;
    }

    public Date getOrderStartTime() {
        return orderStartTime;
    }

    public void setOrderStartTime(Date orderStartTime) {
        this.orderStartTime = orderStartTime;
    }

    public Date getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(Date orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    @Override
    public String toString() {
        return "PayResultBo{" +
                "couponAmount=" + couponAmount +
                ", couponMinUseAmount=" + couponMinUseAmount +
                ", couponStartTime='" + couponStartTime + '\'' +
                ", couponEndTime='" + couponEndTime + '\'' +
                ", payType='" + payType + '\'' +
                ", roomTypeName='" + roomTypeName + '\'' +
                ", payAmount=" + payAmount +
                ", sheetCode='" + sheetCode + '\'' +
                ", orderStartTime='" + orderStartTime + '\'' +
                ", orderEndTime='" + orderEndTime + '\'' +
                ", roomCount=" + roomCount +
                '}';
    }
}
