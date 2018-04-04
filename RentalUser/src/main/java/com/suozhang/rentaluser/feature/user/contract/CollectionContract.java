/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.contract;

import com.suozhang.framework.framework.BasePresenter;
import com.suozhang.framework.framework.BaseView;
import com.suozhang.rentaluser.entity.bo.HouseRoomBo;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:06
 */
public interface CollectionContract {

    interface Model {

        Observable<List<HouseRoomBo>> doGetCollectionList();

    }

    interface View extends BaseView {



        void showSuccess(List<HouseRoomBo> houseRoomBos);


        void showErrorMsg(String msg);

        void showEmpty();

    }


    interface Presenter extends BasePresenter {
        void getCollectionList();

    }
}
