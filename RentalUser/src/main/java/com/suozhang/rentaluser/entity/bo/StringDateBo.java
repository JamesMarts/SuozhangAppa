/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/5/17 14:01
 */
public class StringDateBo implements BaseEntity{
     private String birthday;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public StringDateBo(String birthday) {
        this.birthday = birthday;
    }

    public StringDateBo() {
    }
}
