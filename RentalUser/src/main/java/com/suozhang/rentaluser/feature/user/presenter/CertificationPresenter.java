/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.presenter;

import android.text.TextUtils;

import com.suozhang.framework.utils.T;
import com.suozhang.framework.utils.ValidatorUtil;
import com.suozhang.rentaluser.entity.bo.ZMBo;
import com.suozhang.rentaluser.feature.user.contract.CertificationContract;
import com.suozhang.rentaluser.feature.user.dependencies.certification.DaggerCertificationPresenterComponent;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class CertificationPresenter implements CertificationContract.Presenter {

    private CertificationContract.View mView;

    @Inject

    CertificationContract.Model mModel;


    public CertificationPresenter(CertificationContract.View mView) {
        this.mView = mView;

        DaggerCertificationPresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void doEditName(String card, String name) {
        if (TextUtils.isEmpty(name)) {
            T.showShort("请输入姓名！");
            return;
        }
        if (TextUtils.isEmpty(card)) {
            T.showShort("请输入身份证号码！");
            return;
        }
        if (!ValidatorUtil.isIDCard(card)) {
            T.showShort("请输入身份证号码格式有误！");
            return;
        }
        mModel.doEditName(card, name).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(@NonNull String s) {
                mView.showSuccessMsg(s);

            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.showErrorMsg(e.getMessage());
                mView.dismissLoading();
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }

    @Override
    public void doCheckZhimaScore() {
        mModel.doCheckZhimaScore().compose(mView.<ZMBo>bindToLife()).subscribe(new Observer<ZMBo>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ZMBo zmBo) {
                mView.showZMSuccessMsg(zmBo);
            }

            @Override
            public void onError(Throwable e) {
                mView.showZMErrorMsg(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
