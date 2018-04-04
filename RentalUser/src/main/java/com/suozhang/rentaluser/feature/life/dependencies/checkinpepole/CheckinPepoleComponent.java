/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.dependencies.checkinpepole;


import com.suozhang.rentaluser.feature.life.view.LivePeopleActivity;

import dagger.Component;

/**
 * @author Moodd
 * @email 420410175@qq.com
 * @date 2017/4/17 11:58
 */
@Component(modules = CheckinPepolePresenterModule.class)
public interface CheckinPepoleComponent {

    void inject(LivePeopleActivity target);
}
