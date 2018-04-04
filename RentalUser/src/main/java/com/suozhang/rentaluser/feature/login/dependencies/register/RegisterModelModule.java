/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.login.dependencies.register;

import com.suozhang.rentaluser.feature.login.contract.RegisterContract;
import com.suozhang.rentaluser.feature.login.model.RegisterModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:46
 */
@Module
public class RegisterModelModule {

    @Provides

    public RegisterContract.Model provideRegisterModel() {
        return new RegisterModel();
    }
}
