/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.contract;

import com.suozhang.framework.framework.BasePresenter;
import com.suozhang.framework.framework.BaseView;
import com.suozhang.rentaluser.entity.bo.ContractInfoBo;
import com.suozhang.rentaluser.entity.bo.ContractInfoPramsBo;

import io.reactivex.Observable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:06
 */
public interface ContractInfoContract {

    interface Model {


        Observable<ContractInfoBo> doGetContractInfoList(String contractId);

        Observable<String> doConfirmContract(String contractId);

        Observable<String> doRefauseContract(String contractId,ContractInfoPramsBo contractInfoBo);

        Observable<String> doGetTemplateInfoSuccess(String contractId);
    }

    interface View extends BaseView {


        void showSuccess(ContractInfoBo contractInfoBo);


        void showErrorMsg(String msg);

        void showConfirmSuccess(String msg);

        void showConfirmError(String msg);

        void showRefauseSuccess(String msg);

        void showRefauseError(String msg);

        void showGetTemplateInfoSuccess(String msg);

        void showGetTemplateInfoError(String msg);

    }


    interface Presenter extends BasePresenter {

        void getContractInfoList(String contractId);

        void postConfirmContract(String contractId);

        void postRefauseContract(String contractId,String refusalCause);

        void getTemplateInfo(String contractId);
    }
}
