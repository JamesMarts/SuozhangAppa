/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.entity.enums;

/**
 * Api请求时的头部参数，用于标识App类型，服务端会根据App类型判断是否拥有相应Api调用权限
 * Created by Moodd on 2017/2/24.
 */

public enum GetCodeType {





    Login(0),
    EditPhone(1),
    Register(2),//
    ResetPwd(3),
    WeChatBind(4);
    private final int value;

    GetCodeType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

}
