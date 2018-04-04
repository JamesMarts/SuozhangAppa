/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.contract;

import com.suozhang.framework.framework.BasePresenter;
import com.suozhang.framework.framework.BaseView;
import com.suozhang.rentaluser.entity.bo.RentInfoBo;

import io.reactivex.Observable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:06
 */
public interface HouseContract {

    interface Model {

        Observable<RentInfoBo> doGetRentInfo(String id);

        Observable<String> collectionHouse(String id);

        Observable<String> cancleCollectionHouse(String id);
    }

    interface View extends BaseView {


        void showSuccess(RentInfoBo rentInfoBo);

        /**
         * 显示错误信息
         */

        void showErrorMsg(String msg);

        void showCollectionSuccess(String msg);

        void showCollectionSuccessError(String msg);

        void showCancleCollectionSuccess(String msg);

        void showCancleCollectionError(String msg);

    }


    interface Presenter extends BasePresenter {
        void doGetRentInfo(String id);

        void collectionHouse(String id);

        void cancleCollectionHouse(String id);
    }
}
