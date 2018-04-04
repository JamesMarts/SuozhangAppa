/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.framework.api.dependencies;

import com.suozhang.framework.framework.AM;
import com.suozhang.framework.framework.annotation.ApiScope;
import com.suozhang.rentaluser.framework.api.LifeApi;

import dagger.Module;
import dagger.Provides;

/**
 * @author Moodd
 * @email 420410175@qq.com
 * @date 2017/4/19 10:29
 */

@Module
public class LifeApiModule {
    @ApiScope
    @Provides
    public LifeApi providerLifeApi() {

        return AM.api().createApiService(LifeApi.class);
    }
}
