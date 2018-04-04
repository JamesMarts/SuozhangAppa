package com.suozhang.rentaluser.entity.enums;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/11/16 16:01
 */

public enum SearchType {

    /**
     * 未知类型
     */
    UND(-1),
    /**
     * 整租
     */
    ZHENG(0),
    /**
     * 分租
     */
    FENG(1),
    /**
     * 附近
     */
    NEAR(2),
    /**
     * 关键字
     */
    KEYWORD(3);

    public final int type;

    SearchType(int type) {
        this.type = type;
    }

    public int type() {
        return type;
    }

    public static SearchType typeOf(int value) {
        for (SearchType type : values()) {
            if (type.type() == value) {
                return type;
            }
        }
        return UND;
    }
}
