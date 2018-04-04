/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.presenter;

import com.suozhang.rentaluser.entity.bo.ContractBo;
import com.suozhang.rentaluser.feature.life.contract.ContractContract;
import com.suozhang.rentaluser.feature.life.dependencies.contract.DaggerContractPresenterComponent;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class ContractPresenter implements ContractContract.Presenter {

    private ContractContract.View mView;

    @Inject

    ContractContract.Model mModel;


    public ContractPresenter(ContractContract.View mView) {
        this.mView = mView;

         DaggerContractPresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void getContractList(boolean IsCurrentContract) {
        mModel.doGetContractList(IsCurrentContract).compose(mView.<List<ContractBo>>bindToLife()).subscribe(new Observer<List<ContractBo>>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(List<ContractBo> contractBos) {
                mView.dismissLoading();
                if (contractBos.size() > 0) {
                    mView.showSuccess(contractBos);
                } else {
                    mView.showEmpty();
                }

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
}
