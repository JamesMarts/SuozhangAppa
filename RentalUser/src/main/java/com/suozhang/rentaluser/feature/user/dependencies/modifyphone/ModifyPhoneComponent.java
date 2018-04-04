/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.modifyphone;


import com.suozhang.rentaluser.feature.user.view.ModifyPhoneActivity;

import dagger.Component;

/**
 * @author Moodd
 * @email 420410175@qq.com
 * @date 2017/4/17 11:58
 */
@Component(modules = ModifyPhonePresenterModule.class)
public interface ModifyPhoneComponent {

    void inject(ModifyPhoneActivity target);
}
