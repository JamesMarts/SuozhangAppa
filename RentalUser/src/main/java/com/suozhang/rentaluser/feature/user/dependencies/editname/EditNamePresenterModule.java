/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.editname;

import com.suozhang.rentaluser.feature.user.contract.EditNameContract;
import com.suozhang.rentaluser.feature.user.presenter.EditNamePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class EditNamePresenterModule {
    private final EditNameContract.View mView;

    public EditNamePresenterModule(EditNameContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public EditNameContract.Presenter provideEditNamePresenter() {
        return new EditNamePresenter(mView);
    }

}
