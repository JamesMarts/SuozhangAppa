/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.dependencies.room;


import com.suozhang.rentaluser.feature.life.contract.MyRoomContract;
import com.suozhang.rentaluser.feature.life.model.MyRoomModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:46
 */
@Module
public class MyRoomModelModule {

    @Provides

    public MyRoomContract.Model provideLifeModel() {
        return new MyRoomModel();
    }
}
