/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Moodd
 * @email 420410175@qq.com
 * @date 2017/4/21 11:44
 */

public class UserInfoBo implements BaseEntity {

    /**
     * userId : sample string 1
     * icon : sample string 2
     * bgImage : sample string 3
     * sex : true
     * summary : sample string 5
     * hasCertification : true
     * integral : 7
     * orderCount : 8
     * couponsCount : 9
     * nickName : sample string 10
     * email : sample string 11
     * birthday : 2017-04-21 11:43:21
     */

    private String userId;//用户id
    private String icon;//用户头像url
    private String bgImage;//背景图url
    private boolean sex;//性别 true：男 false：女
    private String summary;//简介
    private String nickName;//昵称
    private String email;//邮箱
    private String birthday;//生日

    // NOTE: 2017/4/21  以下字段暂时不用，主要用户端使用
    // private int integral;//积分
    // private int orderCount;//订单数量
    // private int couponsCount;//优惠券数量

    private boolean hasCertification;//是否认证

    //修改密码时用
    private String oldPwd;//原密码
    private String newPwd1;//新密码
    private String newPwd2;//确认密码

    // NOTE: 2017/5/27  员工登录-新增字段
    private boolean isStaff;//是否员工
    private String name;
    private String phone;//手机号
    private String cardId; //身份证号
    private String address;//住址
    private String constellation;//住址

    /**
     * 获取Date类型的生日
     *
     * @return
     */
    public Date getBirthdayDate() {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return df.parse(this.birthday);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取格式化后的生日 yyyy-MM-dd
     *
     * @return
     */
    public String getBirthdayFormat() {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            return df.format(getBirthdayDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBgImage() {
        return bgImage;
    }

    public void setBgImage(String bgImage) {
        this.bgImage = bgImage;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isHasCertification() {
        return hasCertification;
    }

    public void setHasCertification(boolean hasCertification) {
        this.hasCertification = hasCertification;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd1() {
        return newPwd1;
    }

    public void setNewPwd1(String newPwd1) {
        this.newPwd1 = newPwd1;
    }

    public String getNewPwd2() {
        return newPwd2;
    }

    public void setNewPwd2(String newPwd2) {
        this.newPwd2 = newPwd2;
    }

    public boolean isStaff() {
        return isStaff;
    }

    public void setStaff(boolean staff) {
        isStaff = staff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    @Override
    public String toString() {
        return "UserInfoBo{" +
                "userId='" + userId + '\'' +
                ", icon='" + icon + '\'' +
                ", bgImage='" + bgImage + '\'' +
                ", sex=" + sex +
                ", summary='" + summary + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", oldPwd='" + oldPwd + '\'' +
                ", newPwd1='" + newPwd1 + '\'' +
                ", newPwd2='" + newPwd2 + '\'' +
                ", isStaff='" + isStaff + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", cardId='" + cardId + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
