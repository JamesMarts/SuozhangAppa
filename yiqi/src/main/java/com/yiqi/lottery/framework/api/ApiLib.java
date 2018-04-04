package com.yiqi.lottery.framework.api;


import com.yiqi.lottery.framework.api.dependencies.ApiComponent;
import com.yiqi.lottery.framework.api.dependencies.DaggerApiComponent;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/9/12 15:16
 */

public class ApiLib {
    private static ApiComponent apiComponent;


    public static void initApiComponent() {
        apiComponent = DaggerApiComponent.builder().build();
    }

    public static ApiComponent apiComponent() {
        return apiComponent;
    }
}
