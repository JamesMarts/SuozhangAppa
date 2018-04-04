/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.framework.framework.api.CommonApi;
import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.feature.rental.contract.CityContract;
import com.suozhang.rentaluser.feature.rental.dependencies.city.DaggerCityModelComponent;
import com.suozhang.rentaluser.framework.api.ApiLib;
import com.suozhang.rentaluser.framework.api.RentApi;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:42
 */
public class CityModel implements CityContract.Model {
    @Inject
    CommonApi commonApi;

    @Inject
    RentApi api;

    @Inject
    public CityModel() {

        DaggerCityModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }


    @Override
    public Observable<BaseBo> doGetCityId(String cityName) {
        return api.getCityId(cityName).compose(RxDataProcessFactory.<BaseBo>dataPrepAndIoToMainTransformer());
    }
}
