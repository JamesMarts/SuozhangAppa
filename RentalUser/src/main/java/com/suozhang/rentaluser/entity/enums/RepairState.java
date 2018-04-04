package com.suozhang.rentaluser.entity.enums;

/**
 * 合同状态
 *
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/11/14 11:21
 */

public enum RepairState {

    Refused   ("用户拒绝", 0),
    Confirm  ("合同生效", 1),
    Completed  ("合同终止", 2);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private RepairState(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (RepairState c : RepairState.values()) {
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
