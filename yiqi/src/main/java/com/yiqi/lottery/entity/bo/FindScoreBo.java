package com.yiqi.lottery.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

public class FindScoreBo implements BaseEntity{
    private int type;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public FindScoreBo(int type) {
        this.type = type;
    }

    public FindScoreBo() {
    }
}
