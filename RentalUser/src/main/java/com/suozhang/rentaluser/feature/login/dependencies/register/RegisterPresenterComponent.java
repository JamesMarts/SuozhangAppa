/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.login.dependencies.register;


import com.suozhang.rentaluser.feature.login.presenter.RegisterPresenter;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:53
 */
@Component(modules = RegisterModelModule.class)
public interface RegisterPresenterComponent {
    void inject(RegisterPresenter registerPresenter);
}
