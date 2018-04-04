package com.suozhang.rentaluser.entity.enums;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/12 17:04
 */
public enum LifeMenu {


    MYROOM(0),
    CONTRACT(1),
    PAYMENT_RECORDS(2),//
    REPAIF(3),
    MOVE(4),
    FITMENT(5),
    CLEAN(6),
    WASH(7),//
    MAINTENANCE(8);
    private final int value;

    LifeMenu(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
