/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.contract;

import com.suozhang.framework.framework.BasePresenter;
import com.suozhang.framework.framework.BaseView;
import com.suozhang.rentaluser.entity.bo.MessageBo;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:06
 */
public interface MessageContract {

    interface Model {

        Observable<List<MessageBo>> doMessageTypeList();

        Observable<List<MessageBo>> doMessageInfoList(String msgId);

        Observable<MessageBo> doMessageView(String msgId);

        Observable<Boolean> doUpdateMessageState(String msgId);
    }

    interface View extends BaseView {

        void showSuccess(List<MessageBo> houseRoomBos);

        void showMessageViewSuccess(MessageBo houseRoomBo);

        void showErrorMsg(String msg);

        void showEmpty();

        void showMessageInfoSuccess(List<MessageBo> houseRoomBos);


    }


    interface Presenter extends BasePresenter {
        void getMessageTypeList();

        void doMessageInfoList(String type);

        void doMessageView(String msgId);

        void  doUpdateMessageState(String msgId);
    }
}
