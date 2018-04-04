/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.framework.framework.api.CommonApi;
import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.entity.bo.StringDateBo;
import com.suozhang.rentaluser.entity.bo.UserInfoBo;
import com.suozhang.rentaluser.feature.user.contract.UserInfoContract;
import com.suozhang.rentaluser.feature.user.dependencies.userinfo.DaggerUserInfoModelComponent;
import com.suozhang.rentaluser.framework.api.ApiLib;
import com.suozhang.rentaluser.framework.api.UserApi;

import java.io.File;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

//import com.suozhang.smartalliance.feature.login.dependencies.DaggerLoginModelComponent;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:42
 */
public class UserInfoModel implements UserInfoContract.Model {
    @Inject
    CommonApi commonApi;

    @Inject
    UserApi api;

    @Inject
    public UserInfoModel() {
        DaggerUserInfoModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }


    @Override
    public Observable<String> doUpdateUserIcon(int uploadImgType, File file) {
        RequestBody requestFile = RequestBody.create(MediaType.parse("application/otcet-stream"), file);

        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(), requestFile);

        String type = String.valueOf(uploadImgType);
        RequestBody uploadTypeBody = RequestBody.create(MediaType.parse("multipart/form-data"), type);

        return api.updateUserIcon(uploadTypeBody, filePart).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<UserInfoBo> doUserInfo() {
        return api.getUserInfo().compose(RxDataProcessFactory.<UserInfoBo>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> doEditBirthday(StringDateBo userInfoBo) {
        return api.updateBirthday(userInfoBo).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> doEditGender(UserInfoBo nickName) {
        return api.updateSex(nickName).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> doEditStar(BaseBo star) {
        return api.editConstellation(star).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }
}
