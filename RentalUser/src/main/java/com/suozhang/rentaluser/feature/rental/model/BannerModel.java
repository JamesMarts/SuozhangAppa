/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.framework.framework.api.CommonApi;
import com.suozhang.rentaluser.entity.bo.BannerBo;
import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.entity.bo.HouseRoomBo;
import com.suozhang.rentaluser.feature.rental.contract.BannerContract;
import com.suozhang.rentaluser.feature.rental.dependencies.banner.DaggerBannerModelComponent;
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
public class BannerModel implements BannerContract.Model {
    @Inject
    CommonApi commonApi;

    @Inject
    RentApi api;

    @Inject
    public BannerModel() {

        DaggerBannerModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }


    @Override
    public Observable<List<BannerBo>> doGetBannerList() {
        return api.getBannerList().compose(RxDataProcessFactory.<List<BannerBo>>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<BaseBo> doGetCityId(String cityName) {
        return api.getCityId(cityName).compose(RxDataProcessFactory.<BaseBo>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<List<HouseRoomBo>> doGetLikeHouse(String areaId) {
        return api.getGuestLike(areaId).compose(RxDataProcessFactory.<List<HouseRoomBo>>dataPrepAndIoToMainTransformer());
    }
}
