/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.dependencies.room;


import com.suozhang.rentaluser.feature.life.contract.MyRoomContract;
import com.suozhang.rentaluser.feature.life.presenter.MyRoomPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class MyRoomPresenterModule {
    private final MyRoomContract.View mView;

    public MyRoomPresenterModule(MyRoomContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public MyRoomContract.Presenter provideMyRoomPresenter() {
        return new MyRoomPresenter(mView);
    }

}
