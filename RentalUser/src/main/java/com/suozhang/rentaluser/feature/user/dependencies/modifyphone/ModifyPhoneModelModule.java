/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.modifyphone;


import com.suozhang.rentaluser.feature.user.contract.ModifyPhoneContract;
import com.suozhang.rentaluser.feature.user.model.ModifyPhoneModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author Moodd
 * @e-mail 420410175@qq.com
 * @date 2017/4/14 10:44
 */
@Module
public class ModifyPhoneModelModule {
    @Provides
    public ModifyPhoneContract.Model providerModel() {
        return new ModifyPhoneModel();
    }

}
