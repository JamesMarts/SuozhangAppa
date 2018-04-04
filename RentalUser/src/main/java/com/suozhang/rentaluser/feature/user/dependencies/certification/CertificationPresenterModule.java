/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.certification;


import com.suozhang.rentaluser.feature.user.contract.CertificationContract;
import com.suozhang.rentaluser.feature.user.presenter.CertificationPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class CertificationPresenterModule {
    private final CertificationContract.View mView;

    public CertificationPresenterModule(CertificationContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public CertificationContract.Presenter provideCertificationPresenter() {
        return new CertificationPresenter(mView);
    }

}
