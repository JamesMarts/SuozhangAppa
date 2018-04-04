/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.presenter;

import android.text.TextUtils;

import com.suozhang.rentaluser.entity.bo.ContractInfoBo;
import com.suozhang.rentaluser.entity.bo.ContractInfoPramsBo;
import com.suozhang.rentaluser.feature.life.contract.ContractInfoContract;
import com.suozhang.rentaluser.feature.life.dependencies.contractinfo.DaggerContractInfoPresenterComponent;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class ContractInfoPresenter implements ContractInfoContract.Presenter {

    private ContractInfoContract.View mView;

    @Inject

    ContractInfoContract.Model mModel;


    public ContractInfoPresenter(ContractInfoContract.View mView) {
        this.mView = mView;

        DaggerContractInfoPresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void getContractInfoList(String contractId) {
        if (TextUtils.isEmpty(contractId)) {
            return;
        }
        mModel.doGetContractInfoList(contractId).compose(mView.<ContractInfoBo>bindToLife()).subscribe(new Observer<ContractInfoBo>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(ContractInfoBo contractInfoBo) {
                mView.dismissLoading();
                mView.showSuccess(contractInfoBo);

            }

            @Override
            public void onError(Throwable e) {
                mView.dismissLoading();
                mView.showErrorMsg(e.getMessage());
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }

    @Override
    public void postConfirmContract(String contractId) {
        if (TextUtils.isEmpty(contractId)) {
            return;
        }

        mModel.doConfirmContract(contractId).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(String s) {
                mView.dismissLoading();
                mView.showConfirmSuccess(s);
            }

            @Override
            public void onError(Throwable e) {
                mView.dismissLoading();
                mView.showConfirmError(e.getMessage());
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }

    @Override
    public void postRefauseContract(String contractId,String str) {

        if (TextUtils.isEmpty(contractId)) {
            return;
        }

        ContractInfoPramsBo contractInfoBo1=new ContractInfoPramsBo(str);

        mModel.doRefauseContract(contractId,contractInfoBo1).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(String s) {
                mView.dismissLoading();
                mView.showRefauseSuccess(s);
            }

            @Override
            public void onError(Throwable e) {
                mView.dismissLoading();
                mView.showRefauseError(e.getMessage());
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }


    @Override
    public void getTemplateInfo(String contractId) {
        if (TextUtils.isEmpty(contractId)) {
            return;
        }

        mModel.doGetTemplateInfoSuccess(contractId).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(String s) {
                mView.dismissLoading();
                mView.showGetTemplateInfoSuccess(s);
            }

            @Override
            public void onError(Throwable e) {
                mView.dismissLoading();
                mView.showGetTemplateInfoError(e.getMessage());
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }
}
