/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.modifyphone;


import com.suozhang.rentaluser.feature.user.contract.ModifyPhoneContract;
import com.suozhang.rentaluser.feature.user.presenter.ModifyPhonePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author Moodd
 * @email 420410175@qq.com
 * @date 2017/4/14 10:4
 */
@Module
public class ModifyPhonePresenterModule {

    private final ModifyPhoneContract.View mView;

    public ModifyPhonePresenterModule(ModifyPhoneContract.View view) {
        this.mView = view;
    }

    @Provides
    public ModifyPhoneContract.Presenter providePresenter() {
        return new ModifyPhonePresenter(mView);
    }
}
