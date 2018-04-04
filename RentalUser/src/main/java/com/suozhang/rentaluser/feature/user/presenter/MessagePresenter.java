/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.presenter;

import com.suozhang.framework.utils.T;
import com.suozhang.rentaluser.entity.bo.MessageBo;
import com.suozhang.rentaluser.feature.user.contract.MessageContract;
import com.suozhang.rentaluser.feature.user.dependencies.messagetype.DaggerMessagePresenterComponent;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class MessagePresenter implements MessageContract.Presenter {

    private MessageContract.View mView;

    @Inject

    MessageContract.Model mModel;

    public MessagePresenter(MessageContract.View mView) {
        this.mView = mView;

        DaggerMessagePresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void getMessageTypeList() {
        mModel.doMessageTypeList().compose(mView.<List<MessageBo>>bindToLife()).subscribe(new Observer<List<MessageBo>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<MessageBo> messageBos) {

                if (messageBos != null && messageBos.size() > 0) {
                    mView.showSuccess(messageBos);
                } else {
                    mView.showEmpty();
                }
            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorMsg(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void doMessageInfoList(String msgId) {
        mModel.doMessageInfoList(msgId).compose(mView.<List<MessageBo>>bindToLife()).subscribe(new Observer<List<MessageBo>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<MessageBo> messageBos) {
                if (messageBos != null && messageBos.size() > 0) {
                    mView.showMessageInfoSuccess(messageBos);
                } else {
                    mView.showEmpty();
                }
            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorMsg(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void doMessageView(String msgId) {
        mModel.doMessageView(msgId).compose(mView.<MessageBo>bindToLife()).subscribe(new Observer<MessageBo>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MessageBo messageBos) {

                mView.showMessageViewSuccess(messageBos);

            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorMsg(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void doUpdateMessageState(String msgId) {
        mModel.doUpdateMessageState(msgId).compose(mView.<Boolean>bindToLife()).subscribe(new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Boolean issuccess) {


            }

            @Override
            public void onError(Throwable e) {
                T.showShort(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
