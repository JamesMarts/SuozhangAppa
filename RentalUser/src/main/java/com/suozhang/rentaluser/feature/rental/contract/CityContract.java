/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.contract;

import com.suozhang.framework.framework.BasePresenter;
import com.suozhang.framework.framework.BaseView;
import com.suozhang.rentaluser.entity.bo.BaseBo;

import io.reactivex.Observable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:06
 */
public interface CityContract {

    interface Model {

        Observable<BaseBo> doGetCityId(String cityName);

    }

    interface View extends BaseView {



        void showSuccess(BaseBo baseBo);

        /**
         * 显示错误信息
         */

        void showErrorMsg(String msg);

    }


    interface Presenter extends BasePresenter {
        void getCityId(String cityName);
    }
}
