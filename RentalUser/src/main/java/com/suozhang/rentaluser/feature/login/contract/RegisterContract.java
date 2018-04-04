/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.login.contract;

import com.suozhang.framework.framework.BasePresenter;
import com.suozhang.framework.framework.BaseView;
import com.suozhang.rentaluser.entity.bo.PasswordBo;
import com.suozhang.rentaluser.entity.bo.RegisterBo;

import io.reactivex.Observable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:06
 */
public interface RegisterContract {

    interface Model {

        /**
         * 验证手机号码
         */

        Observable<String> doVerifyPhone(String phone, int codeType);

        /**
         * 获取短信验证码
         */
        Observable<String> doGetVerifyCode(String phone, int codeType);

        /**
         * 验证验证码
         */

        Observable<String> doAuthVerifyCode(String phone, String code);

        /**
         * 用户注册
         */
        Observable<String> doRegister(RegisterBo registerBo);

        /**
         * 用户重置密码
         */
        Observable<String> doResetPassword(RegisterBo registerBo);

        /**
         * 修改绑定手机号
         */

        Observable<String> doEditPhone(PasswordBo passwordBo);

        /**
         * 微信用户绑定手机号
         */

        Observable<String> doWechatBindPhone(String openId, RegisterBo passwordBo);
    }

    interface View extends BaseView {

        void finishActivity();

        void showVerifyPhoneSuccess(String msg);

        void showVerifyPhoneError(String msg);

        void showGetCodeSuccess(String msg);

        void showGetCodeError(String msg);

        void showVerifyCodeSuccess(String msg);

        void showVerifyCodeError(String msg);

        void showRegisterSucess(String msg);

        void showRegisterError(String msg);

        void showResetPasswordSucess(String msg);

        void showResetPasswordError(String msg);

        void showBindPhoneSucess(String msg);

        void showBindPhoneError(String msg);

        void showWxBindPhoneSucess(String msg);

        void showWxBindPhoneError(String msg);
    }


    interface Presenter extends BasePresenter {

        /**
         * 验证手机号码
         */

        void verifyPhone(String phone, int codeType);

        /**
         * 获取短信验证码
         */
        void getVerifyCode(String phone, int codeType);

        /**
         * 验证验证码
         */

        void authVerifyCode(String phone, String code);

        /**
         * 用户注册
         */
        void register(String phone, String password, String rePassword, String code);

        /**
         * 用户重置密码
         */
        void resetPassword(String phone, String password, String rePassword, String code);

        void editPhone(String phone, String code);

        void wechatBindPhone(String openId, String phone, String code);
    }
}
