/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.editpwd;

import com.suozhang.rentaluser.feature.user.presenter.EditPasswordPresenter;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:53
 */
@Component(modules = EditPasswordModelModule.class)
public interface EditPasswordPresenterComponent {
    void inject(EditPasswordPresenter editPasswordPresenter);
}
