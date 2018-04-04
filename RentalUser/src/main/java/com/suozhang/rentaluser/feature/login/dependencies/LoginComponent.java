/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.login.dependencies;


import com.suozhang.rentaluser.feature.login.view.DynamicLoginActivity;
import com.suozhang.rentaluser.feature.login.view.LoginActivity;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:24
 */

@Component(modules = LoginPresenterModule.class)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
    void inject(DynamicLoginActivity dynamicLoginActivity);
}
