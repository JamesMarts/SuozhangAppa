/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.contract;

import com.suozhang.framework.framework.BasePresenter;
import com.suozhang.framework.framework.BaseView;
import com.suozhang.rentaluser.entity.bo.MyLifeBo;

import io.reactivex.Observable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:06
 */
public interface LifeContract {

    interface Model {


        Observable<MyLifeBo> doGetMyRentState();

        Observable<Integer> doGetUnreadMessageCount();
    }

    interface View extends BaseView {


        void showSuccess(MyLifeBo contractBos);


        void showErrorMsg(String msg);

        void showMsgCount(Integer count);

        void showMsgCountError(String msg);

    }


    interface Presenter extends BasePresenter {

        void getMyRentState();

        void doGetUnreadMessageCount();
    }
}
