/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.login.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.framework.entity.bo.LoginRequest;
import com.suozhang.framework.entity.bo.TokenInfo;
import com.suozhang.framework.entity.bo.UserAccount;
import com.suozhang.framework.framework.api.CommonApi;
import com.suozhang.rentaluser.entity.bo.ThirdLoginBo;
import com.suozhang.rentaluser.feature.login.contract.LoginContract;
import com.suozhang.rentaluser.feature.login.dependencies.DaggerLoginModelComponent;
import com.suozhang.rentaluser.framework.api.ApiLib;
import com.suozhang.rentaluser.framework.api.UserApi;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:42
 */
public class LoginModelImpl implements LoginContract.Model {
    @Inject
    CommonApi commonApi;

    @Inject
    UserApi orgApi;


    @Inject
    public LoginModelImpl() {
     DaggerLoginModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }


    @Override
    public Observable<TokenInfo> doUserLogin(LoginRequest<UserAccount> loginRequest) {
        return commonApi.login(loginRequest).compose(RxDataProcessFactory.<TokenInfo>dataPrepAndIoToMainTransformer());

    }

    @Override
    public Observable<String> doGetAuthCode(String phone, int codeType) {
        return orgApi.getAuthCode(phone, codeType).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<TokenInfo> doUserDynamicLogin(LoginRequest<UserAccount> loginRequest) {
        return commonApi.login(loginRequest).compose(RxDataProcessFactory.<TokenInfo>dataPrepAndIoToMainTransformer());
    }


    @Override
    public Observable<Boolean> doUserIsExistByOpenId(String openId) {
        return orgApi.loginCheckUserHasExist(openId).compose(RxDataProcessFactory.<Boolean>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<Boolean> doUserIsBindPhoneByOpenId(String openId) {
        return orgApi.loginCheckUseHasBindPhone(openId).compose(RxDataProcessFactory.<Boolean>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> doUserCreate(ThirdLoginBo thirdLoginBo) {
        return orgApi.loginCreateWeChatUser(thirdLoginBo).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }



}
