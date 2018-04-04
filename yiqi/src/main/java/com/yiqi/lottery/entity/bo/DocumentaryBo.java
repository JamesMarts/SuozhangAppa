package com.yiqi.lottery.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

public class DocumentaryBo implements BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DocumentaryBo(String name) {
        this.name = name;
    }


    public DocumentaryBo() {
    }
}
