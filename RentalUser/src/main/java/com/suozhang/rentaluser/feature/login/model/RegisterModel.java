/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.login.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.framework.framework.api.CommonApi;
import com.suozhang.framework.utils.logger.Logger;
import com.suozhang.rentaluser.entity.bo.PasswordBo;
import com.suozhang.rentaluser.entity.bo.RegisterBo;
import com.suozhang.rentaluser.feature.login.contract.RegisterContract;
import com.suozhang.rentaluser.feature.login.dependencies.register.DaggerRegisterModelComponent;
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
public class RegisterModel implements RegisterContract.Model{
    @Inject
    CommonApi commonApi;

    @Inject
    UserApi api;



    @Inject
    public RegisterModel() {
        DaggerRegisterModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }


    @Override
    public Observable<String> doVerifyPhone(String phone,int codeType) {
        return api.registerVerifyPhone(phone,codeType).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> doGetVerifyCode(String phone, int codeType) {
        return api.getAuthCode(phone,codeType).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> doAuthVerifyCode(String phone, String code) {
        return api.registerVerifyCode(phone,code).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> doRegister(RegisterBo registerBo) {
        return api.registerCommit(registerBo).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> doResetPassword(RegisterBo registerBo) {
        Logger.e("reste----->"+registerBo.toString());
        return api.resetPasswordCommit(registerBo).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> doEditPhone(PasswordBo passwordBo) {
        return api.updatePhone(passwordBo).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> doWechatBindPhone(String openId, RegisterBo passwordBo) {
        return api.loginBindUser(openId,passwordBo).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }
}
