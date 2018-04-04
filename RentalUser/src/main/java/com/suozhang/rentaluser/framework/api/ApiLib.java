package com.suozhang.rentaluser.framework.api;


import com.suozhang.rentaluser.framework.api.dependencies.ApiComponent;
import com.suozhang.rentaluser.framework.api.dependencies.DaggerApiComponent;

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
