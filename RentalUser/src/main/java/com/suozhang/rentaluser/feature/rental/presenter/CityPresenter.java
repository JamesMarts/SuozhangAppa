/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.presenter;

import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.feature.rental.contract.CityContract;
import com.suozhang.rentaluser.feature.rental.dependencies.city.DaggerCityPresenterComponent;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class CityPresenter implements CityContract.Presenter {

    private CityContract.View mView;

    @Inject

    CityContract.Model mModel;


    public CityPresenter(CityContract.View mView) {
        this.mView = mView;

          DaggerCityPresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void getCityId(String cityName) {
        mModel.doGetCityId(cityName).compose(mView.<BaseBo>bindToLife()).subscribe(new Observer<BaseBo>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(BaseBo baseBo) {
                mView.showSuccess(baseBo);
            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorMsg(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
