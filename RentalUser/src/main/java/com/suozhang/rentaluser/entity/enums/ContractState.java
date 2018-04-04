/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.entity.enums;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/5/22 11:05
 */
public enum ContractState {



    Default  ("未创建合同", 0),
    Affirm  ("待用户确认", 1),
    Reject   ("用户拒绝", 2),
    Validate  ("合同生效", 3),
    Termination  ("合同终止", 4);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private ContractState(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (ContractState c : ContractState.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
