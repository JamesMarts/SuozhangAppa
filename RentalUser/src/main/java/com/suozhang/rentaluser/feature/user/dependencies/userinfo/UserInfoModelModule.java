/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.userinfo;

import com.suozhang.rentaluser.feature.user.contract.UserInfoContract;
import com.suozhang.rentaluser.feature.user.model.UserInfoModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:46
 */
@Module
public class UserInfoModelModule {

    @Provides

    public UserInfoContract.Model provideUserInfoModel() {
        return new UserInfoModel();
    }
}
