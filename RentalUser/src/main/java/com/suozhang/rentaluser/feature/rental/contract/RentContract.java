/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.contract;

import com.suozhang.framework.framework.BasePresenter;
import com.suozhang.framework.framework.BaseView;
import com.suozhang.rentaluser.entity.bo.HouseRoomBo;
import com.suozhang.rentaluser.entity.bo.RentParamsBo;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:06
 */
public interface RentContract {

    interface Model {

        Observable<List<HouseRoomBo>> doGetHouseingResourseByFilter(RentParamsBo rentParamsBo);

    }

    interface View extends BaseView {



        void showSuccess(List<HouseRoomBo> houseRoomBos);

        /**
         * 显示错误信息
         */

        void showErrorMsg(String msg);

        void showEmpty();

    }


    interface Presenter extends BasePresenter {
        void getHouseingResourseByFilter(RentParamsBo rentParamsBo);
    }
}
