/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.editname;


import com.suozhang.rentaluser.feature.user.presenter.EditNamePresenter;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:53
 */
@Component(modules = EditNameModelModule.class)
public interface EditNamePresenterComponent {
    void inject(EditNamePresenter editNamePresenter);
}