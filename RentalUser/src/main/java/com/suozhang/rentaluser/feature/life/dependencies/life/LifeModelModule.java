/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.dependencies.life;


import com.suozhang.rentaluser.feature.life.contract.LifeContract;
import com.suozhang.rentaluser.feature.life.model.LifeModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:46
 */
@Module
public class LifeModelModule {

    @Provides

    public LifeContract.Model provideLifeModel() {
        return new LifeModel();
    }
}
