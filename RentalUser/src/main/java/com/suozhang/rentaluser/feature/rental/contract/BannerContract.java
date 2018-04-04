/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.contract;

import com.suozhang.framework.framework.BasePresenter;
import com.suozhang.framework.framework.BaseView;
import com.suozhang.rentaluser.entity.bo.BannerBo;
import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.entity.bo.HouseRoomBo;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:06
 */
public interface BannerContract {

    interface Model {

        Observable<List<BannerBo>> doGetBannerList();

        Observable<BaseBo> doGetCityId(String cityName);

        Observable<List<HouseRoomBo>> doGetLikeHouse(String areaId);
    }

    interface View extends BaseView {


        abstract void showSuccess(List<BannerBo> bannerBos);


        abstract void showErrorMsg(String msg);


        abstract void showAreaSuccess(BaseBo baseBo);


        abstract void showAreaErrorMsg(String msg);


        void showLikeHouseSuccess(List<HouseRoomBo> baseBo);

        void showLikeHouseEmpty();

        void showLikeHouseError(String msg);

    }


    interface Presenter extends BasePresenter {
        void doGetBannerList();

        void getCityId(String cityName);

        void doGetLikeHouse(String areaId);
    }
}
