/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.editpwd;

import com.suozhang.rentaluser.feature.user.view.ModifyPasswordActivity;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:24
 */

@Component(modules = EditPasswordPresenterModule.class)
public interface EditPasswordComponent {
    void inject(ModifyPasswordActivity editPasswordActivity);
}
