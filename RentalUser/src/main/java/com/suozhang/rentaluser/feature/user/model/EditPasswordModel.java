/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.framework.framework.api.CommonApi;
import com.suozhang.rentaluser.entity.bo.PasswordBo;
import com.suozhang.rentaluser.feature.user.contract.EditPasswordContract;
import com.suozhang.rentaluser.feature.user.dependencies.editpwd.DaggerEditPasswordModelComponent;
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
public class EditPasswordModel implements EditPasswordContract.Model {
    @Inject
    CommonApi commonApi;

    @Inject
    UserApi api;

    @Inject
    public EditPasswordModel() {
        DaggerEditPasswordModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }


    @Override
    public Observable<String> doEditPassword(PasswordBo passwordBo) {
        return api.updatePassword(passwordBo).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }
}
