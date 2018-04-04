/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.editpwd;

import com.suozhang.rentaluser.feature.user.contract.EditPasswordContract;
import com.suozhang.rentaluser.feature.user.model.EditPasswordModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:46
 */
@Module
public class EditPasswordModelModule {

    @Provides

    public EditPasswordContract.Model provideEditPasswordModel() {
        return new EditPasswordModel();
    }
}
