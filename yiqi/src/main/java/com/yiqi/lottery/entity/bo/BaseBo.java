package com.yiqi.lottery.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

public class BaseBo implements BaseEntity{

    private String name;
    private Integer num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
