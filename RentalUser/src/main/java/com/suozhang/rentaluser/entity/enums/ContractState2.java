package com.suozhang.rentaluser.entity.enums;

/**
 * 合同状态
 *
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/11/14 11:21
 */

public enum ContractState2 {
    /**
     * 未定义
     */
    UND(-1),

    /**
     * 默认，未创建新合同
     */
    NO_CREATE(0),

    /**
     * 已创建，待用户确认
     */
    CREATED(1),

    /**
     * 用户拒绝
     */
    REJECT(2),

    /**
     * 合同生效
     */
    VALIDATE(3),

    /**
     * 合同终止
     */
    TERMINATION(4);

    private final int state;

    ContractState2(int state) {
        this.state = state;
    }

    public int state() {
        return state;
    }

    public static ContractState2 stateOf(int state) {
        for (ContractState2 value : values()) {
            if (value.state == state) {
                return value;
            }
        }
        return UND;
    }
}
