/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.login.dependencies;


import com.suozhang.rentaluser.feature.login.contract.LoginContract;
import com.suozhang.rentaluser.feature.login.model.LoginModelImpl;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:46
 */
@Module
public class LoginModelModule {

    @Provides

    public LoginContract.Model provideLoginModel() {
        return new LoginModelImpl();
    }
}
