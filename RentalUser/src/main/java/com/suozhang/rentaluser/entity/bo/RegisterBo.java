/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author Moodd
 * @email 420410175@qq.com
 * @date 2017/7/5 9:46
 */

public class RegisterBo implements BaseEntity {
    //  Login(0),
    //  EditPhone(1),
    //   Register(2),//
    //  ResetPwd(3);

    /**
     * phone : sample string 1
     * code : sample string 2
     * newPassword : sample string 3
     * confirmPassword : sample string 4
     */

    private String oldPhone;//原手机号
    private String phone;//手机号
    private String code;//验证码
    private String newPassword;//密码
    private String confirmPassword;//确认密码

    public RegisterBo() {
    }

    public RegisterBo(String phone, String code) {
        this.phone = phone;
        this.code = code;
    }

    public RegisterBo(String phone, String code, String newPassword, String confirmPassword) {
        this.phone = phone;
        this.code = code;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public RegisterBo(String phone, String newPassword, String confirmPassword) {
        this.phone = phone;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public String getOldPhone() {
        return oldPhone;
    }

    public void setOldPhone(String oldPhone) {
        this.oldPhone = oldPhone;
    }

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

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "RegisterBo{" +
                "oldPhone='" + oldPhone + '\'' +
                "phone='" + phone + '\'' +
                "code='" + code + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
