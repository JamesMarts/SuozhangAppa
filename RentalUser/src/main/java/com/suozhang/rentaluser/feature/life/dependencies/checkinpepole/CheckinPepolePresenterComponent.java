/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.dependencies.checkinpepole;


import com.suozhang.rentaluser.feature.life.presenter.CheckinPepolePresenter;

import dagger.Component;

/**
 * @author Moodd
 * @email 420410175@qq.com
 * @date 2017/4/17 13:34
 */
@Component(modules = CheckinPepoleModelModule.class)
public interface CheckinPepolePresenterComponent {

    void inject(CheckinPepolePresenter presenter);
}
