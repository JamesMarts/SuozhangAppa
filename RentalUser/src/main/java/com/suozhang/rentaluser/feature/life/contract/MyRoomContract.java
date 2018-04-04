/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.contract;

import com.suozhang.framework.framework.BasePresenter;
import com.suozhang.framework.framework.BaseView;
import com.suozhang.rentaluser.entity.bo.MyRoomBo;

import io.reactivex.Observable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:06
 */
public interface MyRoomContract {

    interface Model {


        Observable<MyRoomBo> doGetMyRoomInfo();
    }

    interface View extends BaseView {


        void showSuccess(MyRoomBo roomBo);


        void showErrorMsg(String msg);

    }


    interface Presenter extends BasePresenter {

        void getMyRoomInfo();
    }
}
