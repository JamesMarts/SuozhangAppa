/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.framework.framework.api.CommonApi;
import com.suozhang.rentaluser.entity.bo.HouseRoomBo;
import com.suozhang.rentaluser.entity.bo.RentParamsBo;
import com.suozhang.rentaluser.feature.rental.contract.RentContract;
import com.suozhang.rentaluser.feature.rental.dependencies.rent.DaggerRentModelComponent;
import com.suozhang.rentaluser.framework.api.ApiLib;
import com.suozhang.rentaluser.framework.api.RentApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:42
 */
public class RentModel implements RentContract.Model {
    @Inject
    CommonApi commonApi;

    @Inject
    RentApi api;

    @Inject
    public RentModel() {

        DaggerRentModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }


    @Override
    public Observable<List<HouseRoomBo>> doGetHouseingResourseByFilter(RentParamsBo rentParamsBo) {
        return api.getHouseResourseList(rentParamsBo).compose(RxDataProcessFactory.<List<HouseRoomBo>>dataPrepAndIoToMainTransformer());
    }
}
