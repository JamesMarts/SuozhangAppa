/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.login.dependencies;

import com.suozhang.rentaluser.feature.login.presenter.LoginPresenter;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:53
 */
@Component(modules = LoginModelModule.class)
public interface LoginPresenterComponent {
    void inject(LoginPresenter loginPresenter);
}
