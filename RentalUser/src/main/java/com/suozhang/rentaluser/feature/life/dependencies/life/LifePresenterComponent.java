/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.dependencies.life;

import com.suozhang.rentaluser.feature.life.presenter.LifePresenter;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:53
 */
@Component(modules = LifeModelModule.class)
public interface LifePresenterComponent {
    void inject(LifePresenter lifePresenter);
}
