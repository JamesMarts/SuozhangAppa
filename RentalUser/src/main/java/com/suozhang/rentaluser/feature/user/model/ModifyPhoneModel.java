package com.suozhang.rentaluser.feature.user.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.rentaluser.entity.bo.RegisterBo;
import com.suozhang.rentaluser.feature.user.contract.ModifyPhoneContract;
import com.suozhang.rentaluser.feature.user.dependencies.modifyphone.DaggerModifyPhoneModelComponent;
import com.suozhang.rentaluser.framework.api.ApiLib;
import com.suozhang.rentaluser.framework.api.UserApi;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/9/18 14:23
 */

public class ModifyPhoneModel implements ModifyPhoneContract.Model {
    @Inject
    UserApi api;

    public ModifyPhoneModel() {
        DaggerModifyPhoneModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }

    @Override
    public Observable<String> doSendCode(String phone, int codeType) {
        return api.getAuthCode(phone, codeType).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> doModifyPhone(RegisterBo resetPassword) {
        return api.editPhone(resetPassword).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }
}
