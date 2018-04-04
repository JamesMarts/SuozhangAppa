/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.framework.framework.api.CommonApi;
import com.suozhang.rentaluser.entity.bo.UserInfoBo;
import com.suozhang.rentaluser.feature.user.contract.UserCenterContract;
import com.suozhang.rentaluser.feature.user.dependencies.ediruser.DaggerUserModelComponent;
import com.suozhang.rentaluser.framework.api.ApiLib;
import com.suozhang.rentaluser.framework.api.UserApi;

import javax.inject.Inject;

import io.reactivex.Observable;

//import com.suozhang.smartalliance.feature.login.dependencies.DaggerLoginModelComponent;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:42
 */
public class UserModel implements UserCenterContract.Model {
    @Inject
    CommonApi commonApi;

    @Inject
    UserApi api;

    @Inject
    public UserModel() {
        DaggerUserModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }


    @Override
    public Observable<UserInfoBo> doUserInfo() {
        return api.getUserInfo().compose(RxDataProcessFactory.<UserInfoBo>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<Integer> doGetUnreadMessageCount() {
        return api.GetUnreadMessageCount().compose(RxDataProcessFactory.<Integer>dataPrepAndIoToMainTransformer());
    }
}
