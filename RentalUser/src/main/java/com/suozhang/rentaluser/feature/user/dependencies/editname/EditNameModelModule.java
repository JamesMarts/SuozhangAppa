/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.editname;


import com.suozhang.rentaluser.feature.user.contract.EditNameContract;
import com.suozhang.rentaluser.feature.user.model.EditNameModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:46
 */
@Module
public class EditNameModelModule {

    @Provides

    public EditNameContract.Model provideEditNameModel() {
        return new EditNameModel();
    }
}
