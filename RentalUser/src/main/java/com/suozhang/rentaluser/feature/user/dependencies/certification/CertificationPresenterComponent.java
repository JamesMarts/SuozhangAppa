/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.certification;

import com.suozhang.rentaluser.feature.user.presenter.CertificationPresenter;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:53
 */
@Component(modules = CertificationModelModule.class)
public interface CertificationPresenterComponent {
    void inject(CertificationPresenter certificationPresenter);
}
