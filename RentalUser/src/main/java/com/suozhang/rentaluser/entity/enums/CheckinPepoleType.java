package com.suozhang.rentaluser.entity.enums;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/11/16 16:01
 */

public enum CheckinPepoleType {
    /**
     * 未知类型
     */
    UND(-1),
    /**
     * 承租人
     */
    TENANT(1),
    /**
     * 入住人
     */
    CHECKIN(2);

    public final int type;

    CheckinPepoleType(int type) {
        this.type = type;
    }

    public int type() {
        return type;
    }

    public static CheckinPepoleType typeOf(int value) {
        for (CheckinPepoleType type : values()) {
            if (type.type() == value) {
                return type;
            }
        }
        return UND;
    }
}
