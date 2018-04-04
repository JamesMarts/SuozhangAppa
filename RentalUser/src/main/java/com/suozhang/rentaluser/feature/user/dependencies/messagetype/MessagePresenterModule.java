/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.messagetype;


import com.suozhang.rentaluser.feature.user.contract.MessageContract;
import com.suozhang.rentaluser.feature.user.presenter.MessagePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class MessagePresenterModule {
    private final MessageContract.View mView;

    public MessagePresenterModule(MessageContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public MessageContract.Presenter provideMessagePresenter() {
        return new MessagePresenter(mView);
    }

}
