package com.suozhang.rentaluser.entity.enums;

/**
 * 出租类型
 *
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/10/13 11:03
 */

public enum RentType {
    DEFAULT(null, "整租/分租"),
    WHOLE_RENT(true, "整租"),
    SEPARATE_RENT(false, "分租");

    private final Boolean type;

    private final String typeName;

    RentType(Boolean type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public Boolean type() {
        return type;
    }

    public String typeStr() {
        return type == null ? "" : type ? "true" : "false";
    }

    public String typeName() {
        return typeName;
    }
}
