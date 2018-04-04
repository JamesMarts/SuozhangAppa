/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/5/17 15:46
 */
public class PasswordBo implements BaseEntity {


    /**
     * oldPwd : sample string 1
     * newPwd1 : sample string 2
     * newPwd2 : sample string 3
     */

    private String oldPwd;
    private String newPwd1;
    private String newPwd2;

    private String phone;
    private String code;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public PasswordBo(String oldPwd, String newPwd1, String newPwd2) {
        this.oldPwd = oldPwd;
        this.newPwd1 = newPwd1;
        this.newPwd2 = newPwd2;
    }

    public PasswordBo() {
    }

    @Override
    public String toString() {
        return "PasswordBo{" +
                "oldPwd='" + oldPwd + '\'' +
                ", newPwd1='" + newPwd1 + '\'' +
                ", newPwd2='" + newPwd2 + '\'' +
                '}';
    }
}
