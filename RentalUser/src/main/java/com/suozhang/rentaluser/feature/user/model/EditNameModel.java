/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.framework.framework.api.CommonApi;
import com.suozhang.rentaluser.entity.bo.UserInfoBo;
import com.suozhang.rentaluser.feature.user.contract.EditNameContract;
import com.suozhang.rentaluser.feature.user.dependencies.editname.DaggerEditNameModelComponent;
import com.suozhang.rentaluser.framework.api.ApiLib;
import com.suozhang.rentaluser.framework.api.UserApi;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:42
 */
public class EditNameModel implements EditNameContract.Model{
    @Inject
    CommonApi commonApi;

@Inject
UserApi api;

    @Inject
    public EditNameModel() {

        DaggerEditNameModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }


    @Override
    public Observable<String> doEditName(UserInfoBo userInfoBo) {
        return api.updateNickName(userInfoBo).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }


}
