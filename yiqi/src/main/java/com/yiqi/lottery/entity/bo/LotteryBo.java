package com.yiqi.lottery.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

public class LotteryBo implements BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LotteryBo(String name) {
        this.name = name;
    }


    public LotteryBo() {
    }


}
