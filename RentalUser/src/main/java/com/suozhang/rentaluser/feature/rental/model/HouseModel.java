/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.framework.framework.api.CommonApi;
import com.suozhang.rentaluser.entity.bo.RentInfoBo;
import com.suozhang.rentaluser.feature.rental.contract.HouseContract;
import com.suozhang.rentaluser.feature.rental.dependencies.house.DaggerHouseModelComponent;
import com.suozhang.rentaluser.framework.api.ApiLib;
import com.suozhang.rentaluser.framework.api.RentApi;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:42
 */
public class HouseModel implements HouseContract.Model {
    @Inject
    CommonApi commonApi;

    @Inject
    RentApi api;

    @Inject
    public HouseModel() {

        DaggerHouseModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }


    @Override
    public Observable<RentInfoBo> doGetRentInfo(String id) {
        return api.getHotelInfo(id).compose(RxDataProcessFactory.<RentInfoBo>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> collectionHouse(String id) {
        return api.collectionHouse(id).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> cancleCollectionHouse(String id) {
        return api.cancleCollectionHouse(id).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }
}
