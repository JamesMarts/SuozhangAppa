/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.login.dependencies;

import com.suozhang.framework.framework.annotation.ModelScope;
import com.suozhang.rentaluser.feature.login.model.LoginModelImpl;
import com.suozhang.rentaluser.framework.api.dependencies.ApiComponent;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:36
 */
@ModelScope
@Component(dependencies = ApiComponent.class)
public interface LoginModelComponent {

    void inject(LoginModelImpl loginModel);
}
