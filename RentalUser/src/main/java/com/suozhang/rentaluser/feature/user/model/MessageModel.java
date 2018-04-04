/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.rentaluser.entity.bo.MessageBo;
import com.suozhang.rentaluser.feature.user.contract.MessageContract;
import com.suozhang.rentaluser.feature.user.dependencies.messagetype.DaggerMessageModelComponent;
import com.suozhang.rentaluser.framework.api.ApiLib;
import com.suozhang.rentaluser.framework.api.UserApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:42
 */
public class MessageModel implements MessageContract.Model {


    @Inject
    UserApi api;

    @Inject
    public MessageModel() {

        DaggerMessageModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }



    @Override
    public Observable<List<MessageBo>> doMessageTypeList() {
        return api.getUserMessageTypeList().compose(RxDataProcessFactory
                .<List<MessageBo>>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<List<MessageBo>> doMessageInfoList(String msgId) {
        return api.getMessageTypeList(msgId).compose(RxDataProcessFactory.<List<MessageBo>>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<MessageBo> doMessageView(String msgId) {
        return api.GetMessageInfo(msgId).compose(RxDataProcessFactory.<MessageBo>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<Boolean> doUpdateMessageState(String msgId) {
        return api.UpdateMessageState(msgId).compose(RxDataProcessFactory.<Boolean>dataPrepAndIoToMainTransformer());
    }
}
