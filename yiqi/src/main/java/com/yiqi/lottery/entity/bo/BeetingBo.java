package com.yiqi.lottery.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

public class BeetingBo implements BaseEntity {

    private String name;
    private int result;
    private int type;
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BeetingBo() {
    }

    public BeetingBo(String name) {
        this.name = name;
    }
}
