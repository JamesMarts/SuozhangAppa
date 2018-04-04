/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.modifyphone;


import com.suozhang.rentaluser.feature.user.presenter.ModifyPhonePresenter;

import dagger.Component;

/**
 * @author Moodd
 * @email 420410175@qq.com
 * @date 2017/4/17 13:34
 */
@Component(modules = ModifyPhoneModelModule.class)
public interface ModifyPhonePresenterComponent {

    void inject(ModifyPhonePresenter presenter);
}
