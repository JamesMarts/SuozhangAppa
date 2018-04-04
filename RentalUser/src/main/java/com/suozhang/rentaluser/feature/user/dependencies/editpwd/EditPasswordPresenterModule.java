/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.editpwd;


import com.suozhang.rentaluser.feature.user.contract.EditPasswordContract;
import com.suozhang.rentaluser.feature.user.presenter.EditPasswordPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class EditPasswordPresenterModule {
    private final EditPasswordContract.View mView;

    public EditPasswordPresenterModule(EditPasswordContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public EditPasswordContract.Presenter provideEditPasswordPresenter() {
        return new EditPasswordPresenter(mView);
    }

}
