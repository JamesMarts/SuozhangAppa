/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.dependencies.checkinpepole;


import com.suozhang.rentaluser.feature.life.contract.CheckinPepoleContract;
import com.suozhang.rentaluser.feature.life.model.CheckinPepoleModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author Moodd
 * @e-mail 420410175@qq.com
 * @date 2017/4/14 10:44
 */
@Module
public class CheckinPepoleModelModule {
    @Provides
    public CheckinPepoleContract.Model providerModel() {
        return new CheckinPepoleModel();
    }

}
