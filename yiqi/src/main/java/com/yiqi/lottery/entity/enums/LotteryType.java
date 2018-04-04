package com.yiqi.lottery.entity.enums;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/5/22 11:05
 */
public enum LotteryType {


    HONGDAN("红单榜", 0),
    LIANHONG("连红榜", 1),
    DAIHONG("带红榜", 2);


    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private LotteryType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (LotteryType c : LotteryType.values()) {
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