/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.certification;

import com.suozhang.framework.framework.annotation.ModelScope;
import com.suozhang.rentaluser.feature.user.model.CertificationModel;
import com.suozhang.rentaluser.framework.api.dependencies.ApiComponent;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:36
 */
@ModelScope
@Component(dependencies = ApiComponent.class)
public interface CertificationModelComponent {

    void inject(CertificationModel UserFragment);
}
